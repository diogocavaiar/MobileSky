package sky.diogo.com.br.mobiletestsky.data.remote.repository

import io.reactivex.Observable
import sky.diogo.com.br.mobiletestsky.data.model.Movies
import sky.diogo.com.br.mobiletestsky.data.remote.service.MoviesService

class MoviesDataRepository : Repository {

    private val mService = MoviesService()

    override fun getMovies(): Observable<List<Movies>> {
        return mService.getService().getMovies()
    }
}