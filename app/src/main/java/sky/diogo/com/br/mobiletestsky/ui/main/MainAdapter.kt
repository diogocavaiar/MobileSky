package sky.diogo.com.br.mobiletestsky.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sky.diogo.com.br.mobiletestsky.R
import sky.diogo.com.br.mobiletestsky.data.model.Movies

class MainAdapter(val listener: OnClickCard, var mMovies: MutableList<Movies> = mutableListOf()) : RecyclerView.Adapter<MainViewHolder>() {

    private val VIEW_TYPE_EMPTY_STATE = 0
    private val VIEW_TYPE_DADOS = 1

    override fun getItemViewType(position: Int): Int {
        return if (mMovies.isEmpty()) VIEW_TYPE_EMPTY_STATE else VIEW_TYPE_DADOS
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val view: View
        if (viewType == VIEW_TYPE_DADOS)
            view = inflater.inflate(R.layout.row_activity_main, parent, false)
        else
            view = inflater.inflate(R.layout.row_empty_state, parent, false)

        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mMovies.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        if(holder.itemViewType == VIEW_TYPE_DADOS)
            holder.bind(mMovies[position], listener)
    }

    fun setMovies(movies: List<Movies>) {
        if(movies != null)
            for(movie: Movies in movies) {
                if(mMovies.contains(movie))
                    continue
                mMovies.add(movie)
            }
        notifyDataSetChanged()
    }
}