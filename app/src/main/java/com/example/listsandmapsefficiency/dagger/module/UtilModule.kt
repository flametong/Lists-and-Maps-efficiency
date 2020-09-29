package com.example.listsandmapsefficiency.dagger.module

import com.example.listsandmapsefficiency.util.Counter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilModule {

    @Provides
    @Singleton
    fun provideCounter(): Counter = Counter()

}