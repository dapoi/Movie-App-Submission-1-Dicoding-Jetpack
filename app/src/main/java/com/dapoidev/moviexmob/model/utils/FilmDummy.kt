package com.dapoidev.moviexmob.model.utils

import com.dapoidev.moviexmob.R
import com.dapoidev.moviexmob.model.FilmModel

object FilmDummy {
    fun generateMovie(): List<FilmModel> {
        val movies = ArrayList<FilmModel>()

        movies.add(
            FilmModel(
                R.drawable.poster_aquaman,
                "Aquaman",
                "December 7, 2018"
            )
        )

        movies.add(
            FilmModel(
                R.drawable.poster_cold_persuit,
                "Cold Pursuit",
                "February 7, 2019"
            )
        )

        movies.add(
            FilmModel(
                R.drawable.poster_creed,
                "Creed",
                "November 25, 2015"
            )
        )

        movies.add(
            FilmModel(
                R.drawable.poster_crimes,
                "Crimes",
                "November 14, 2018"
            )
        )

        movies.add(
            FilmModel(
                R.drawable.poster_glass,
                "Glass",
                "January 16, 2019"
            )
        )

        movies.add(
            FilmModel(
                R.drawable.poster_how_to_train,
                "How to Train Your Dragon",
                "March 10, 2010"
            )
        )

        movies.add(
            FilmModel(
                R.drawable.poster_infinity_war,
                "Avengers: Infinity War",
                "April 25, 2018"
            )
        )

        movies.add(
            FilmModel(
                R.drawable.poster_overlord,
                "Overlord",
                "November 1, 2018"
            )
        )

        movies.add(
            FilmModel(
                R.drawable.poster_robin_hood,
                "Robin Hood",
                "November 21, 2018"
            )
        )

        movies.add(
            FilmModel(
                R.drawable.poster_spiderman,
                "Spiderman",
                "May 1, 2002"
            )
        )
        return movies
    }


    fun generateTVShow(): List<FilmModel> {
        val tvShows = ArrayList<FilmModel>()

        tvShows.add(
            FilmModel(
                R.drawable.poster_arrow,
                "Arrow",
                "October 10, 2012"
            )
        )

        tvShows.add(
            FilmModel(
                R.drawable.poster_dragon_ball,
                "Dragon Ball",
                "February 26, 1986"
            )
        )

        tvShows.add(
            FilmModel(
                R.drawable.poster_fairytail,
                "Fairy Tail",
                "October 12, 2009"
            )
        )

        tvShows.add(
            FilmModel(
                R.drawable.poster_family_guy,
                "Family Guy",
                "January 31, 1999"
            )
        )

        tvShows.add(
            FilmModel(
                R.drawable.poster_naruto_shipudden,
                "Naruto Shippuden",
                "February 15, 2007"
            )
        )

        tvShows.add(
            FilmModel(
                R.drawable.poster_ncis,
                "Ncis",
                "September 23, 2003"
            )
        )

        tvShows.add(
            FilmModel(
                R.drawable.poster_riverdale,
                "Riverdale",
                "January 26, 2017"
            )
        )

        tvShows.add(
            FilmModel(
                R.drawable.poster_supernatural,
                "Supernatural",
                "September 13, 2005"
            )
        )

        tvShows.add(
            FilmModel(
                R.drawable.poster_the_simpson,
                "The Simpson",
                "December 17, 1989"
            )
        )

        tvShows.add(
            FilmModel(
                R.drawable.poster_the_walking_dead,
                "The Walking Dead",
                "October 31, 2010"
            )
        )

        return tvShows
    }
}