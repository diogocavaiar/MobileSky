package sky.diogo.com.br.mobiletestsky.data.remote

import io.reactivex.Observable
import retrofit2.http.GET
import sky.diogo.com.br.mobiletestsky.data.model.Movies

interface MoviesApi {

    @GET("Movies")
    fun getMovies() : Observable<List<Movies>>

}