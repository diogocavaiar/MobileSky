package sky.diogo.com.br.mobiletestsky.ui.main

import android.content.Intent
import android.support.design.widget.Snackbar
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.GridLayoutManager
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_main.*
import sky.diogo.com.br.mobiletestsky.R
import sky.diogo.com.br.mobiletestsky.ui.base.BaseActivity
import sky.diogo.com.br.mobiletestsky.data.model.Movies
import sky.diogo.com.br.mobiletestsky.ui.detail.DetailActivity
import sky.diogo.com.br.mobiletestsky.util.Constants


class MainActivity : BaseActivity(), MainView, OnClickCard {

    lateinit var mPresenter: MainPresenter

    lateinit var mAdapter: MainAdapter

    val mGridLayoutManager = GridLayoutManager(this, 2)

    override fun getResId(): Int {
        return R.layout.activity_main
    }

    override fun initAdapter() {
        mAdapter = MainAdapter(this)
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

    override fun showProgress() {
        activity_main_progressBar.visibility = ProgressBar.VISIBLE
    }

    override fun hideProgress() {
        activity_main_progressBar.visibility = ProgressBar.GONE
    }

    override fun makeVisible() {
        activity_main_tvTitle.visibility = AppCompatTextView.VISIBLE
    }

    override fun loadMovies(movies: List<Movies>) {
        mAdapter.setMovies(movies)
    }

    override fun showMessage(message: String) {
        Snackbar.make(activity_main_root, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun navigationToDetail(title: String?, image: String?, overview: String?) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(Constants.TITLE, title)
        intent.putExtra(Constants.IMAGE, image)
        intent.putExtra(Constants.OVERVIEW, overview)
        startActivity(intent)
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
