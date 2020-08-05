package com.theintsuhtwe.enjoywithme.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.theintsuhtwe.enjoywithme.fragments.ActionFragment


class MovieFragmentStateAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return ActionFragment.newInstance()
    }
}