package com.example.runing_city.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.runing_city.R
import com.example.runing_city.databinding.FragmentHomeBinding
import com.example.runing_city.ui.mapPoint.PointViewModel

class HomeFragment : Fragment() {

    private lateinit var pointViewModel: PointViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        pointViewModel =
            ViewModelProviders.of(requireActivity()).get(PointViewModel::class.java)
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )
        binding.pointModel = pointViewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}
