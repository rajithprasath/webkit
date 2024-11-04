package com.krutik.webkitdemo.sample.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.krutik.webkitdemo.sample.fragments.AccountsFragment
import com.krutik.webkitdemo.sample.fragments.DashboardFragment
import com.krutik.webkitdemo.sample.fragments.RewardsFragment
import com.krutik.webkitdemo.sample.fragments.ServicesFragment
import com.krutik.webkitdemo.sample.fragments.WealthFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> DashboardFragment()
        1 -> AccountsFragment()
        2 -> WealthFragment()
        3 -> RewardsFragment()
        else -> ServicesFragment()
    }

    override fun getItemId(position: Int): Long {
        // Return a unique ID for each position
        return position.toLong()
    }

    override fun containsItem(itemId: Long): Boolean {
        // Always return true so that fragments are not recreated
        return itemId < itemCount
    }
}
