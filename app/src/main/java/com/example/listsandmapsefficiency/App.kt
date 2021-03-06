package com.example.listsandmapsefficiency

import android.app.Application
import com.example.listsandmapsefficiency.dagger.AppComponent
import com.example.listsandmapsefficiency.dagger.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var context: App
            private set
        lateinit var appComponent: AppComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        appComponent = DaggerAppComponent.create()
    }
}
