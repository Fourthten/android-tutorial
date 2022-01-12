package com.example.movielist

import com.example.movielist.di.DaggerAppComponent
import dagger.android.support.DaggerApplication
import dagger.android.AndroidInjector

class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().application(this).build()
}