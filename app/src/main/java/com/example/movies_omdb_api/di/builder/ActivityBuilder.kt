package com.example.movies_omdb_api.di.builder

import com.example.movies_omdb_api.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    internal abstract fun bindMainActivity(): MainActivity
}