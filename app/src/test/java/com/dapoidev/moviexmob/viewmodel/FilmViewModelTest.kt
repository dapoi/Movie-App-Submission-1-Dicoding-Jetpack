package com.dapoidev.moviexmob.viewmodel

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class FilmViewModelTest {

    private lateinit var viewModel: FilmViewModel

    @Before
    fun set() {
        viewModel = FilmViewModel()
    }

    @Test
    fun getMovie() {
        val filmModel = viewModel.getMovie()
        assertNotNull(filmModel)
        assertEquals(10, filmModel.size)
    }

    @Test
    fun getTVShow() {
        val filmModel = viewModel.getTVShows()
        assertNotNull(filmModel)
        assertEquals(10, filmModel.size)
    }
}