package com.alan.retoandroidalan.features.tasks.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alan.retoandroidalan.R
import com.alan.retoandroidalan.core.BaseFragment
import com.alan.retoandroidalan.databinding.FragmentListTasksBinding

class ListTasksFragment : BaseFragment() {

    private lateinit var binding: FragmentListTasksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListTasksBinding.inflate(inflater)
        return binding.root
    }

}