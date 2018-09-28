package sky.diogo.com.br.mobiletestsky.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getResId())
        initAdapter()
        initUI()
        initPresenter()
    }

    abstract fun getResId(): Int
    abstract fun initAdapter()
    abstract fun initUI()
    abstract fun initPresenter()
}