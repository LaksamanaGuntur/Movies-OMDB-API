package com.example.movies_omdb_api.di.component

import android.app.Application
import com.example.movies_omdb_api.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import com.example.movies_omdb_api.di.builder.ActivityBuilder
import com.example.movies_omdb_api.di.module.NetworkModule
import com.example.movies_omdb_api.di.module.DataModule
import com.example.movies_omdb_api.di.module.EndpointModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidInjectionModule::class),
    (NetworkModule::class),
    (DataModule::class),
    (EndpointModule::class),
    (ActivityBuilder::class)
])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}