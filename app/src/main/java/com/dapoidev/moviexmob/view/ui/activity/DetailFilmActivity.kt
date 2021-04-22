package com.dapoidev.moviexmob.view.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dapoidev.moviexmob.R
import com.dapoidev.moviexmob.databinding.ActivityDetailFilmBinding
import com.dapoidev.moviexmob.databinding.ContentDetailFilmBinding
import com.dapoidev.moviexmob.model.FilmDetailModel
import com.dapoidev.moviexmob.viewmodel.DetailFilmViewModel

class DetailFilmActivity : AppCompatActivity() {

    companion object {
        const val EXTRAS_DETAIL = "extras_detail"
    }

    private lateinit var detailBinding: ContentDetailFilmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailFilmBinding = ActivityDetailFilmBinding.inflate(layoutInflater)
        detailBinding = activityDetailFilmBinding.detailFilm
        setContentView(activityDetailFilmBinding.root)

        setSupportActionBar(activityDetailFilmBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (supportActionBar != null) title = "Detail's"

        val detailViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailFilmViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val title = extras.getString(EXTRAS_DETAIL)
            if (title != null) {
                detailViewModel.setSelectedFilm(title)
                detailFilm(detailViewModel.getSelectedFilm())
            }
        }
    }

    private fun detailFilm(film: FilmDetailModel) {
        Glide.with(this)
            .load(film.cover)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(detailBinding.imgDetail)

        detailBinding.apply {
            tvDetailTitle.text = film.title
            tvDetailDate.text = film.date
            tvDetailGenre.text = film.genre
            tvDetailDesc.text = film.desc
        }
    }
}