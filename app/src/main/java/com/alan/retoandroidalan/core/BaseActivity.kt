package com.alan.retoandroidalan.core

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getLayoutResourceId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResourceId())
    }

    fun changeFragment(@IdRes container: Int, fragment: Fragment){
        supportFragmentManager.apply {
            beginTransaction().replace(container, fragment).addToBackStack(fragment.tag).commit()
        }
    }
}