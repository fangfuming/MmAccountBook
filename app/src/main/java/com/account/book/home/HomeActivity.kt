package com.account.book.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.account.book.R
import com.account.book.databinding.ActivityHomeBinding

/**
 * @Description:
 * @Author: Luke
 * @CreateDate: 2024/7/11 15:57
 * @Version: 1.0
 */
class HomeActivity:AppCompatActivity() {


    private lateinit var fragmentController:FragmentController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFragmentController()
    }

    private fun initFragmentController() {
        val fragmentData = mutableListOf<Fragment>(
            MainFragment(),
            MineFragment()
        )
        fragmentController = FragmentController.newInstance(this, R.id.fl_container, fragmentData)
    }

}