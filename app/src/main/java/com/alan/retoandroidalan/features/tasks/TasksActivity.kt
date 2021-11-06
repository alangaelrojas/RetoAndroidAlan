package com.alan.retoandroidalan.features.tasks

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alan.retoandroidalan.R
import com.alan.retoandroidalan.core.BaseActivity
import com.alan.retoandroidalan.features.user.login.LoginFragment

class TasksActivity : BaseActivity() {

    override fun getLayoutResourceId(): Int = R.layout.activity_tasks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        changeFragment(R.id.tasks_container, LoginFragment())
    }

    companion object {
        fun startActivity(context: Context){
            context.startActivity(Intent(context, TasksActivity::class.java))
        }
    }
}