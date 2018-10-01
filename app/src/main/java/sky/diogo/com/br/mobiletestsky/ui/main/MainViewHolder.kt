package sky.diogo.com.br.mobiletestsky.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_activity_main.view.*
import sky.diogo.com.br.mobiletestsky.data.model.Movies

class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var mView: View = view

    fun bind(movie: Movies, listener: OnClickCard) {
        Glide.with(mView.row_activity_main_imageMovie.context)
                .load(movie.cover_url)
                .into(mView.row_activity_main_imageMovie)

        mView.row_activity_main_tvTitle.text = movie.title

        mView._row_activity_main_card.setOnClickListener{listener.navigationToDetail(movie.title, movie.cover_url, movie.overview)}
    }
}