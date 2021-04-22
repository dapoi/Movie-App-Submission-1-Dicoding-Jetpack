package com.dapoidev.moviexmob.viewmodel

import androidx.lifecycle.ViewModel
import com.dapoidev.moviexmob.model.FilmModel
import com.dapoidev.moviexmob.model.utils.FilmDummy

class FilmViewModel : ViewModel() {

    fun getMovie(): List<FilmModel> = FilmDummy.generateMovie()

    fun getTVShows(): List<FilmModel> = FilmDummy.generateTVShow()
}