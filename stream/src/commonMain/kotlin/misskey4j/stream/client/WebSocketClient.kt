package misskey4j.stream.client


class WebSocketClient(uri: java.net.URI, listener: WebSocketListener) {
    private val mURI: java.net.URI = uri
    private var mSocket: java.net.Socket? = null
    private var mThread: java.lang.Thread? = null
    private val mParser: HybiParser
    private val mListener: WebSocketListener = listener
    private val mService: java.util.concurrent.ExecutorService

    private val mSendLock = Any()

    init {
        mParser = HybiParser(this)
        mService = java.util.concurrent.Executors.newSingleThreadExecutor()
    }

    val listener: misskey4j.stream.client.WebSocketListener
        get() = mListener

    fun connect() {
        if (mThread != null && mThread.isAlive()) {
            return
        }

        mThread = java.lang.Thread(java.lang.Runnable {
            try {
                val secret = createSecret()
                logger.debug("Secret: $secret")

                var path = if (isEmpty(mURI.getPath())) "/" else mURI.getPath()
                if (!isEmpty(mURI.getQuery())) {
                    path += "?" + mURI.getQuery()
                }

                val originScheme = if (mURI.getScheme() == "wss") "https" else "http"
                val origin: java.net.URI = java.net.URI(originScheme, "//" + mURI.getHost(), null)

                val factory: javax.net.SocketFactory =
                    if (mURI.getScheme() == "wss") sSLSocketFactory else javax.net.SocketFactory.getDefault()
                mSocket = factory.createSocket(mURI.getHost(), port)

                val out: java.io.PrintWriter = java.io.PrintWriter(mSocket.getOutputStream())
                writeRN(out, "GET $path HTTP/1.1")
                writeRN(out, "Upgrade: websocket")
                writeRN(out, "Connection: Upgrade")
                writeRN(out, "Host: " + mURI.getHost())
                writeRN(out, "Origin: " + origin.toString())
                writeRN(out, "Sec-WebSocket-Key: $secret")
                writeRN(out, "Sec-WebSocket-Version: 13")
                writeRN(out, "")
                out.flush()

                val stream: HybiParser.HappyDataInputStream =
                    HappyDataInputStream(mSocket.getInputStream())

                // Read HTTP response status line.
                val status = readLine(stream)
                logger.debug(status)

                // Read HTTP response headers.
                var line: String?
                while (!isEmpty(readLine(stream).also { line = it })) {
                    logger.debug(line)
                }

                mListener.onConnect()

                // Now decode websocket frames.
                mParser.start(stream)
            } catch (ex: java.io.EOFException) {
                logger.debug("WebSocket EOF!", ex)
                mListener.onDisconnect(0, "EOF")
            } catch (ex: javax.net.ssl.SSLException) {
                // Connection reset by peer
                logger.debug("Websocket SSL error!", ex)
                mListener.onDisconnect(0, "SSL")
            } catch (ex: java.lang.Exception) {
                mListener.onError(ex)
                mListener.onDisconnect(0, "UNEXPECTED")
            }
        })
        mThread.start()
    }

    private val port: Int
        get() = if ((mURI.getPort() != -1)) mURI.getPort() else (if (mURI.getScheme() == "wss") 443 else 80)

    fun disconnect() {
        if (mSocket != null) {
            mService.submit(java.lang.Runnable {
                try {
                    mSocket.close()
                    mSocket = null
                } catch (ex: java.io.IOException) {
                    logger.debug("Error while disconnecting", ex)
                    mListener.onError(ex)
                }
            })
        }
    }

    fun send(data: String?) {
        sendFrame(mParser.frame(data))
    }

    fun send(data: ByteArray?) {
        sendFrame(mParser.frame(data))
    }

    fun sendPing() {
        sendFrame(mParser.pingFrame())
    }

    // Can't use BufferedReader because it buffers past the HTTP data.
    @Throws(java.io.IOException::class)
    private fun readLine(reader: HybiParser.HappyDataInputStream): String? {
        var readChar: Int = reader.read()
        if (readChar == -1) {
            return null
        }
        val string: java.lang.StringBuilder = java.lang.StringBuilder("")
        while (readChar != '\n'.code) {
            if (readChar != '\r'.code) {
                string.append(readChar.toChar())
            }

            readChar = reader.read()
            if (readChar == -1) {
                return null
            }
        }
        return string.toString()
    }

    private fun createSecret(): String {
        val nonce = ByteArray(16)
        for (i in 0..15) {
            nonce[i] = (java.lang.Math.random() * 256).toInt().toByte()
        }
        return java.util.Base64.getEncoder().encodeToString(nonce).trim { it <= ' ' }
    }

    private fun isEmpty(str: String?): Boolean {
        return str == null || str.isEmpty()
    }

    private fun writeRN(writer: java.io.PrintWriter, line: String) {
        logger.debug(line)
        writer.print(line + "\r\n")
    }

    fun sendFrame(frame: ByteArray?) {
        mService.submit(java.lang.Runnable {
            try {
                synchronized(mSendLock) {
                    if (mSocket == null) {
                        throw java.lang.IllegalStateException("Socket not connected")
                    }
                    val outputStream: java.io.OutputStream = mSocket.getOutputStream()
                    outputStream.write(frame)
                    outputStream.flush()
                }
            } catch (e: java.io.IOException) {
                mListener.onError(e)
            }
        })
    }

    @get:Throws(java.security.NoSuchAlgorithmException::class, java.security.KeyManagementException::class)
    private val sSLSocketFactory: javax.net.ssl.SSLSocketFactory
        get() {
            val context: javax.net.ssl.SSLContext = javax.net.ssl.SSLContext.getInstance("TLS")
            context.init(null, null, null)
            return context.getSocketFactory()
        }

    companion object {
        private val logger: Logger = Logger.getLogger(WebSocketClient::class.java)
    }
}