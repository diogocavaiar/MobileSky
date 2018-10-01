package sky.diogo.com.br.mobiletestsky.data.remote.service

import sky.diogo.com.br.mobiletestsky.data.remote.ApiClient
import sky.diogo.com.br.mobiletestsky.data.remote.MoviesApi

class MoviesService {

    fun getService(): MoviesApi {
        return ApiClient.getClient()
    }

}