package work.socialhub.kmisskey.internal.api

import work.socialhub.kmisskey.MisskeyAPI.DriveFiles
import work.socialhub.kmisskey.MisskeyAPI.DriveFilesShow
import work.socialhub.kmisskey.MisskeyAPI.DriveFolders
import work.socialhub.kmisskey.api.DriveResource
import work.socialhub.kmisskey.api.request.drive.DriveFilesRequest
import work.socialhub.kmisskey.api.request.drive.DriveFilesShowRequest
import work.socialhub.kmisskey.api.request.drive.DriveFoldersRequest
import work.socialhub.kmisskey.entity.File
import work.socialhub.kmisskey.entity.Folder
import work.socialhub.kmisskey.entity.share.Response
import work.socialhub.kmisskey.util.toBlocking

class DriveResourceImpl(
    uri: String,
    i: String
) : AbstractResourceImpl(uri, i),
    DriveResource {

    /**
     * {@inheritDoc}
     */
    override suspend fun files(
        request: DriveFilesRequest
    ): Response<Array<File>> {
        return post(DriveFiles.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun filesBlocking(
        request: DriveFilesRequest
    ): Response<Array<File>> {
        return toBlocking {
            files(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun folders(
        request: DriveFoldersRequest
    ): Response<Array<Folder>> {
        return post(DriveFolders.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun foldersBlocking(
        request: DriveFoldersRequest
    ): Response<Array<Folder>> {
        return toBlocking {
            folders(request)
        }
    }

    /**
     * {@inheritDoc}
     */
    override suspend fun showFile(
        request: DriveFilesShowRequest
    ): Response<File> {
        return post(DriveFilesShow.path, request)
    }

    /**
     * {@inheritDoc}
     */
    override fun showFileBlocking(
        request: DriveFilesShowRequest
    ): Response<File> {
        return toBlocking {
            showFile(request)
        }
    }
}
