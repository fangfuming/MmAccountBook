package com.account.book.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.account.book.R
import com.account.book.databinding.FragmentMainBinding

/**
 * @Description:
 * @Author: Luke
 * @CreateDate: 2024/7/11 16:20
 * @Version: 1.0
 */
class MainFragment: Fragment(){

    lateinit  var binding:FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.rv.apply {
            layoutManager = GridLayoutManager(requireContext(),2)
            adapter = MainAdapter()
        }
    }
}