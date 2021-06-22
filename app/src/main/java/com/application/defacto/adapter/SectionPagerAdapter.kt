package com.application.defacto.adapter

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.application.defacto.R
import com.application.defacto.menu.law.fragment.keputusan_presiden.KeputusanPresidenFragment
import com.application.defacto.menu.law.fragment.peraturan_pemerintah.PeraturanPemerintahFragment
import com.application.defacto.menu.law.fragment.peraturan_presiden.PeraturanPresidenFragment
import com.application.defacto.menu.law.fragment.undang_undang.UndangUndangFragment

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.undang_undang,
            R.string.peraturan_pemerintah,
            R.string.peraturan_presiden,
            R.string.keputusan_presiden)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> UndangUndangFragment()
            1 -> PeraturanPemerintahFragment()
            2 -> PeraturanPresidenFragment()
            3 -> KeputusanPresidenFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence = context.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = TAB_TITLES.size

}