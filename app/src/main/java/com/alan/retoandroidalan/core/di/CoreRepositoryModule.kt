package com.alan.retoandroidalan.core.di

import com.alan.retoandroidalan.core.callback.InitSessionRepository
import com.alan.retoandroidalan.core.callback.TasksRepository
import com.alan.retoandroidalan.core.implementations.InitSessionImpl
import com.alan.retoandroidalan.core.implementations.TasksImpl
import dagger.Module
import dagger.Provides

@Module
class CoreRepositoryModule {

    @Provides
    fun provideInitSessionImpl(): InitSessionRepository = InitSessionImpl()

    @Provides
    fun provideTasksRepository(): TasksRepository = TasksImpl()
}