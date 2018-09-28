package sky.diogo.com.br.mobiletestsky.ui.main

import sky.diogo.com.br.mobiletestsky.ui.base.BaseView
import sky.diogo.com.br.mobiletestsky.ui.data.model.Movies

interface MainView : BaseView {

    fun loadMovies(movies: List<Movies>)

}