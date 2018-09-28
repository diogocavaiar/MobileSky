package sky.diogo.com.br.mobiletestsky.ui.main

import sky.diogo.com.br.mobiletestsky.ui.base.BaseMvpPresenter

interface MainPresenter : BaseMvpPresenter<MainView> {
    fun loadMovies()
}