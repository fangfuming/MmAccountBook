package com.account.book.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

/**
 * author：Sicily
 * Date： 2024/3/25 09:58
 * Description：Fragment控制器,控制Fragment的显示隐藏
 */
class FragmentController() {
    private var containerId = 0
    private var fm: FragmentManager? = null
    private var fragments: MutableList<Fragment> = ArrayList()

    private var currentPos = 0

    fun getCurrentPos(): Int {
        return currentPos
    }

    companion object {
        fun newInstance(activity: FragmentActivity, containerId: Int,fragments:MutableList<Fragment>) = FragmentController(activity, containerId,fragments)
    }

    constructor(activity: FragmentActivity, containerId: Int,fragments:MutableList<Fragment>) : this() {
        this.containerId = containerId
        this.fragments = fragments
        fm = activity.supportFragmentManager
        initFragment()
    }

    private fun initFragment() {
        val transaction = fm!!.beginTransaction()
        if (fragments!=null){
            fragments.forEachIndexed { index, fragment ->
                transaction.add(containerId, fragment,"$index")
            }
        }
        transaction.commitAllowingStateLoss()
    }

    fun showFragment(position: Int) {
        currentPos = position
        hideFragments()
        val fragment = fragments[position]
        fm?.let {
            val transaction = it.beginTransaction()
            transaction.show(fragment)
            transaction.commitAllowingStateLoss()
        }
    }

    fun hideFragments() {
        fm?.let {
            val transaction = it.beginTransaction()
            for (fragment in fragments) {
                if (fragment != null) {
                    transaction.hide(fragment)
                }
            }
            transaction.commitAllowingStateLoss()
        }
    }

    fun getFragment(position: Int): Fragment {
        return fragments[position]
    }
}