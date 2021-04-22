package com.dapoidev.moviexmob.view.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dapoidev.moviexmob.view.ui.fragment.MoviesFragment
import com.dapoidev.moviexmob.view.ui.fragment.TVShowsFragment

class SectionPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MoviesFragment()
            1 -> TVShowsFragment()
            else -> MoviesFragment()
        }
}