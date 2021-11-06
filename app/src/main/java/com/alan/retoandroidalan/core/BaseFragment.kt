package com.alan.retoandroidalan.core

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    fun changeFragment(@IdRes container: Int, fragment: Fragment){
        requireActivity().supportFragmentManager.apply {
            beginTransaction().replace(container, fragment).addToBackStack(fragment.tag).commit()
        }
    }

}