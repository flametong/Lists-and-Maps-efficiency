package com.example.listsandmapsefficiency.dagger.module

import com.example.listsandmapsefficiency.repository.CustomSharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPreferencesModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(): CustomSharedPreferences =
        CustomSharedPreferences()
}