package com.dapoidev.moviexmob.viewmodel

import androidx.lifecycle.ViewModel
import com.dapoidev.moviexmob.model.FilmDetailModel
import com.dapoidev.moviexmob.model.utils.FilmDetailDummy

class DetailFilmViewModel : ViewModel() {
    private lateinit var title: String
    private lateinit var film: FilmDetailModel

    fun setSelectedFilm(titleMovie: String) {
        this.title = titleMovie
    }

    fun getSelectedFilm(): FilmDetailModel {
        val moviesModel = FilmDetailDummy.generateDetailMovie()
        for (movieModel in moviesModel) {
            if (movieModel.title == title) film = movieModel
        }
        val tvShowsModel = FilmDetailDummy.generateDetailTVShow()
        for (tvShowModel in tvShowsModel) {
            if (tvShowModel.title == title) film = tvShowModel
        }
        return film
    }

}