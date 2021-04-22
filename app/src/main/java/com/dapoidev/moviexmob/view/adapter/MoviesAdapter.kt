package com.dapoidev.moviexmob.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dapoidev.moviexmob.R
import com.dapoidev.moviexmob.databinding.ItemsMovieBinding
import com.dapoidev.moviexmob.model.FilmModel
import com.dapoidev.moviexmob.view.ui.activity.DetailFilmActivity

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private val listItem = ArrayList<FilmModel>()

    fun setMovie(movies: List<FilmModel>?) {
        if (movies.isNullOrEmpty()) return
        this.listItem.clear()
        this.listItem.addAll(movies)
    }

    inner class MoviesViewHolder(private val binding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: FilmModel) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(movie.cover)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgMovie)

                tvTitleMovie.text = movie.title
                tvDateMovie.text = movie.date

                itemView.setOnClickListener {
                    Intent(itemView.context, DetailFilmActivity::class.java).also {
                        it.putExtra(DetailFilmActivity.EXTRAS_DETAIL, movie.title)
                        itemView.context.startActivity(it)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesAdapter.MoviesViewHolder {
        val view = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesAdapter.MoviesViewHolder, position: Int) =
        holder.bind(movie = listItem[position])


    override fun getItemCount(): Int = listItem.size
}