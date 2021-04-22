package com.dapoidev.moviexmob.view.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dapoidev.moviexmob.databinding.FragmentTvShowsBinding
import com.dapoidev.moviexmob.view.adapter.TVShowAdapter
import com.dapoidev.moviexmob.viewmodel.FilmViewModel
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper

class TVShowsFragment : Fragment() {

    private lateinit var fragmentTvShowsBinding: FragmentTvShowsBinding
    private lateinit var tvShowsViewModel: FilmViewModel
    private lateinit var tvShowsAdapter: TVShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowsBinding = FragmentTvShowsBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            tvShowsViewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[FilmViewModel::class.java]

            val listTVShows = tvShowsViewModel.getTVShows()

            tvShowsAdapter = TVShowAdapter()
            tvShowsAdapter.setTVShow(listTVShows)

            configRecyclerView()
        }
    }

    private fun configRecyclerView() {
        fragmentTvShowsBinding.rvShows.apply {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = tvShowsAdapter

            OverScrollDecoratorHelper.setUpOverScroll(
                fragmentTvShowsBinding.rvShows,
                OverScrollDecoratorHelper.ORIENTATION_VERTICAL
            )
        }
    }
}