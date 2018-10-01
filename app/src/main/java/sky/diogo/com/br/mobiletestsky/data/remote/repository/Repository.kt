package sky.diogo.com.br.mobiletestsky.data.remote.repository

import io.reactivex.Observable
import sky.diogo.com.br.mobiletestsky.data.model.Movies

interface Repository {
    fun getMovies() : Observable<List<Movies>>
}