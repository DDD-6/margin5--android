package com.margin.wine.main

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.margin.wine.thumbnail.ThumbnailFragment
import com.margin.wine.wine.WineListFragment

class MainPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int) = when(position) {
        0 -> ThumbnailFragment.newInstance()
        else -> WineListFragment.newInstance()
    }
}