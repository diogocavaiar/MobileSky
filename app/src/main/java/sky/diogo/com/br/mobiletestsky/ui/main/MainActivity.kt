package sky.diogo.com.br.mobiletestsky.ui.main

import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import sky.diogo.com.br.mobiletestsky.R
import sky.diogo.com.br.mobiletestsky.ui.base.BaseActivity
import sky.diogo.com.br.mobiletestsky.ui.data.model.Movies


class MainActivity : BaseActivity(), MainView {

    lateinit var mPresenter: MainPresenter

    lateinit var mAdapter: MainAdapter

    val mGridLayoutManager = GridLayoutManager(this, 2)//AutoFitGridLayoutManager(this, 500)

    override fun getResId(): Int {
        return R.layout.activity_main
    }

    override fun initAdapter() {
        mAdapter = MainAdapter()
    }

    override fun initUI() {
        activity_main_recyclerView.layoutManager = mGridLayoutManager
        activity_main_recyclerView.adapter = mAdapter
    }

    override fun initPresenter() {
        mPresenter = MainPresenterImpl()
        mPresenter.attach(this)
        mPresenter.loadMovies()
    }

    override fun loadMovies(movies: List<Movies>) {
        mAdapter.setMovies(movies)
    }

    override fun showMessage(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPause() {
        super.onPause()
        mPresenter.unsubscribe()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detach()
        mPresenter.unsubscribe()
    }
}
