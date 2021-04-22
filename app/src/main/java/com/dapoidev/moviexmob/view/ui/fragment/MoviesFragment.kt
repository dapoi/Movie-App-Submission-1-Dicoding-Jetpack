package com.dapoidev.moviexmob.view.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dapoidev.moviexmob.databinding.FragmentMoviesBinding
import com.dapoidev.moviexmob.view.adapter.MoviesAdapter
import com.dapoidev.moviexmob.viewmodel.FilmViewModel
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper

class MoviesFragment : Fragment() {

    private lateinit var fragmentMoviesBinding: FragmentMoviesBinding
    private lateinit var filmViewModel: FilmViewModel
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            filmViewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[FilmViewModel::class.java]

            val listMovies = filmViewModel.getMovie()

            moviesAdapter = MoviesAdapter()
            moviesAdapter.setMovie(listMovies)

            configRecyclerView()
        }
    }

    private fun configRecyclerView() {
        fragmentMoviesBinding.rvMovies.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = moviesAdapter

            OverScrollDecoratorHelper.setUpOverScroll(
                fragmentMoviesBinding.rvMovies,
                OverScrollDecoratorHelper.ORIENTATION_VERTICAL
            )
        }
    }
}