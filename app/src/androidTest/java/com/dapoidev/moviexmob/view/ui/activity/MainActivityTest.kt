package com.dapoidev.moviexmob.view.ui.activity

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dapoidev.moviexmob.R
import com.dapoidev.moviexmob.model.utils.FilmDetailDummy
import com.dapoidev.moviexmob.model.utils.FilmDummy
import org.junit.Rule
import org.junit.Test

class  MainActivityTest {

    private val movieDummy = FilmDummy.generateMovie()
    private val tvDummy = FilmDummy.generateTVShow()

    private val movieDetailDummy = FilmDetailDummy.generateDetailMovie()
    private val tvShowDetailDummy = FilmDetailDummy.generateDetailTVShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadListMovieAndTVShow() {
        // movies list
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(movieDummy.size))

        // tv show list
        onView(withId(R.id.viewPager)).perform(swipeLeft())
        onView(withId(R.id.rv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvDummy.size))
    }

    @Test
    fun movieDetail() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.img_detail)).check(matches(isDisplayed()))

        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(movieDetailDummy[0].title)))

        onView(withId(R.id.tv_detail_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_date)).check(matches(withText(movieDetailDummy[0].date)))

        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(withText(movieDetailDummy[0].genre)))

        onView(withId(R.id.tv_detail_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_desc)).check(matches(withText(movieDetailDummy[0].desc)))

        pressBack()
    }

    @Test
    fun tvShowDetail() {
        onView(withId(R.id.nav_tv_shows)).perform(click())
        onView(withId(R.id.rv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        onView(withId(R.id.rv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.img_detail)).check(matches(isDisplayed()))

        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(tvShowDetailDummy[0].title)))

        onView(withId(R.id.tv_detail_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_date)).check(matches(withText(tvShowDetailDummy[0].date)))

        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(withText(tvShowDetailDummy[0].genre)))

        onView(withId(R.id.tv_detail_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_desc)).check(matches(withText(tvShowDetailDummy[0].desc)))

        pressBack()
    }
}