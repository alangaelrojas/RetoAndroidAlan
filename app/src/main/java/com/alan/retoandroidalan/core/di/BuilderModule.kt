package com.alan.retoandroidalan.core.di

import dagger.Module

@Module(
    includes = [
        CoreDomainModule::class
    ]
)
abstract class BuilderModule