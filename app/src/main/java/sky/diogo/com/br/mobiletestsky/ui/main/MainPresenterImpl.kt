package sky.diogo.com.br.mobiletestsky.ui.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import sky.diogo.com.br.mobiletestsky.ui.base.BasePresenter
import sky.diogo.com.br.mobiletestsky.ui.data.remote.repository.MoviesDataRepository

class MainPresenterImpl : BasePresenter<MainView>(), MainPresenter {

    private val mRepository = MoviesDataRepository()

    override fun loadMovies() {
        addDisposable(mRepository.getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.loadMovies(it)
                }, {
                    view?.showMessage(it.message!!)
                })
        )
    }
}