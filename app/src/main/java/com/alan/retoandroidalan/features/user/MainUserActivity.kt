package com.alan.retoandroidalan.features.user

import android.os.Bundle
import com.alan.retoandroidalan.R
import com.alan.retoandroidalan.core.BaseActivity
import com.alan.retoandroidalan.features.user.login.LoginFragment

class MainUserActivity : BaseActivity() {

    override fun getLayoutResourceId(): Int = R.layout.main_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        changeFragment(R.id.login_container, LoginFragment())
    }


}