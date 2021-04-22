package com.dapoidev.moviexmob.viewmodel

import com.dapoidev.moviexmob.model.utils.FilmDetailDummy
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailFilmViewModelTest {

    private lateinit var viewModel: DetailFilmViewModel
    private val filmMovieDetailDummy = FilmDetailDummy.generateDetailMovie()[0]
    private val filmTVDummy = FilmDetailDummy.generateDetailTVShow()[0]
    private val titleMovie = filmMovieDetailDummy.title
    private val titleTVShow = filmTVDummy.title

    @Before
    fun set() {
        viewModel = DetailFilmViewModel()
        viewModel.setSelectedFilm(titleMovie)
        viewModel.setSelectedFilm(titleTVShow)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedFilm(filmMovieDetailDummy.title)
        val filmDetailModel = viewModel.getSelectedFilm()
        assertNotNull(filmDetailModel)
        assertEquals(filmMovieDetailDummy.cover, filmDetailModel.cover)
        assertEquals(filmMovieDetailDummy.title, filmDetailModel.title)
        assertEquals(filmMovieDetailDummy.date, filmDetailModel.date)
        assertEquals(filmMovieDetailDummy.genre, filmDetailModel.genre)
        assertEquals(filmMovieDetailDummy.desc, filmDetailModel.desc)
    }

    @Test
    fun getTVShow() {
        viewModel.setSelectedFilm(filmTVDummy.title)
        val filmDetailModel = viewModel.getSelectedFilm()
        assertNotNull(filmDetailModel)
        assertEquals(filmTVDummy.cover, filmDetailModel.cover)
        assertEquals(filmTVDummy.title, filmDetailModel.title)
        assertEquals(filmTVDummy.date, filmDetailModel.date)
        assertEquals(filmTVDummy.genre, filmDetailModel.genre)
        assertEquals(filmTVDummy.desc, filmDetailModel.desc)
    }
}