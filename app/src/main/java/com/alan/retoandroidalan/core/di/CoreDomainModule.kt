package com.alan.retoandroidalan.core.di

import com.alan.retoandroidalan.core.callback.InitSessionRepository
import com.alan.retoandroidalan.features.user.login.domain.interactor.LoginInteractor
import dagger.Module
import dagger.Provides

@Module(includes = [
    CoreRepositoryModule::class
])
class CoreDomainModule {

    @Provides
    fun provideLoginInteractor(
        initSessionRepository: InitSessionRepository
    ): LoginInteractor = LoginInteractor(initSessionRepository)

}