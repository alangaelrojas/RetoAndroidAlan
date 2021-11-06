package com.alan.retoandroidalan.core.di.root

import android.app.Application
import android.content.Context
import com.alan.retoandroidalan.MainApplication
import com.alan.retoandroidalan.core.di.BuilderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    BuilderModule::class
])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: MainApplication)
}