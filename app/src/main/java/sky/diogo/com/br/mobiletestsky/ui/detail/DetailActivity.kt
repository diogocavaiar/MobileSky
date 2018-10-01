package sky.diogo.com.br.mobiletestsky.ui.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import sky.diogo.com.br.mobiletestsky.R
import sky.diogo.com.br.mobiletestsky.util.Constants
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.row_activity_detail.*


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initUI()
    }

    private fun initUI() {

        val actionBar = getSupportActionBar()
        if(actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true)

        activity_detail_collapsing_toolbar!!.title = intent.getStringExtra(Constants.TITLE)

        Glide.with(activity_detail_image!!.context)
                .load(intent.getStringExtra(Constants.IMAGE))
                .into(activity_detail_image)

        row_activity_detail_title.text = intent.getStringExtra(Constants.TITLE)
        row_activity_detail_overview.text = intent.getStringExtra(Constants.OVERVIEW)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}