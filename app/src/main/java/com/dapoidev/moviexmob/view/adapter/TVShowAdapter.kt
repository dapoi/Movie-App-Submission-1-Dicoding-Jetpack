package com.dapoidev.moviexmob.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dapoidev.moviexmob.R
import com.dapoidev.moviexmob.databinding.ItemsShowBinding
import com.dapoidev.moviexmob.model.FilmModel
import com.dapoidev.moviexmob.view.ui.activity.DetailFilmActivity

class TVShowAdapter : RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder>() {
    private val listItem = ArrayList<FilmModel>()

    fun setTVShow(tvShows: List<FilmModel>?) {
        if (tvShows.isNullOrEmpty()) return
        this.listItem.clear()
        this.listItem.addAll(tvShows)
    }

    inner class TVShowViewHolder(private val binding: ItemsShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: FilmModel) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(tvShow.cover)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgShows)

                tvTitleShows.text = tvShow.title
                tvDateShows.text = tvShow.date

                itemView.setOnClickListener {
                    Intent(itemView.context, DetailFilmActivity::class.java).also {
                        it.putExtra(DetailFilmActivity.EXTRAS_DETAIL, tvShow.title)
                        itemView.context.startActivity(it)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val view = ItemsShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) =
        holder.bind(tvShow = listItem[position])

    override fun getItemCount(): Int = listItem.size
}