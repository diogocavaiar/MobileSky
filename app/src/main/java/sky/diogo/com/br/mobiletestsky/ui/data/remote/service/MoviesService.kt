package sky.diogo.com.br.mobiletestsky.ui.data.remote.service

import sky.diogo.com.br.mobiletestsky.ui.data.remote.ApiClient
import sky.diogo.com.br.mobiletestsky.ui.data.remote.MoviesApi

class MoviesService {

    fun getService(): MoviesApi {
        return ApiClient.getClient()
    }

}