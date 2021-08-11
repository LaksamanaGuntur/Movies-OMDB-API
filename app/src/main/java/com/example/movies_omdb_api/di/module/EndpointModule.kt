package com.example.movies_omdb_api.di.module

import com.example.movies_omdb_api.BuildConfig
import com.example.movies_omdb_api.di.ApiInfo
import dagger.Module
import dagger.Provides

@Module
class EndpointModule {

    @Provides
    @ApiInfo
    internal fun provideApiEndpoint(): String = BuildConfig.ENDPOINT_API
}