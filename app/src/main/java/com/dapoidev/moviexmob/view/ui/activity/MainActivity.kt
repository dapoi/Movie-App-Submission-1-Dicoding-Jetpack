package com.dapoidev.moviexmob.view.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.dapoidev.moviexmob.R
import com.dapoidev.moviexmob.databinding.ActivityMainBinding
import com.dapoidev.moviexmob.view.adapter.SectionPagerAdapter
import com.dapoidev.moviexmob.view.ui.fragment.MoviesFragment
import com.dapoidev.moviexmob.view.ui.fragment.TVShowsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navSelectListener =
        BottomNavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_movies -> {
                    MoviesFragment()
                    binding.viewPager.currentItem = 0
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_tv_shows -> {
                    TVShowsFragment()
                    binding.viewPager.currentItem = 1
                    return@OnNavigationItemSelectedListener true
                }
                else -> binding.viewPager.currentItem = 0
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.apply {
            setOnNavigationItemSelectedListener(navSelectListener)
            selectedItemId = R.id.nav_movies
        }

        configViewPager()
    }

    private fun configViewPager() {
        binding.apply {
            val sectionPagerAdapter = SectionPagerAdapter(supportFragmentManager)
            viewPager.adapter = sectionPagerAdapter

            viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                }

                override fun onPageSelected(position: Int) {
                    bottomNav.menu.getItem(position).isChecked = true
                }

                override fun onPageScrollStateChanged(state: Int) {
                }

            })
        }
    }
}