package com.example.movies_omdb_api.di.module

import android.app.Application
import android.content.Context
import com.example.movies_omdb_api.utils.rx.AppSchedulerProvider
import com.example.movies_omdb_api.utils.rx.SchedulerProvider

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()
}