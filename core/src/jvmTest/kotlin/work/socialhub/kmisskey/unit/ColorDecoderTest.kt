package work.socialhub.kmisskey.unit

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import work.socialhub.kmisskey.util.ColorDecoder

class ColorDecoderTest {

    @Test
    fun decodeHexWithPrefix() {
        val color = ColorDecoder.decode("#86b300")

        assertEquals(0x86, color.r)
        assertEquals(0xb3, color.g)
        assertEquals(0x00, color.b)
    }

    @Test
    fun decodeHexWithoutPrefix() {
        val color = ColorDecoder.decode("86b300")

        assertEquals(0x86, color.r)
        assertEquals(0xb3, color.g)
        assertEquals(0x00, color.b)
    }
}
