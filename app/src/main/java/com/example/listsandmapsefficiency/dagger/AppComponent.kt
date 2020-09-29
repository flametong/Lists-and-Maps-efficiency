package com.example.listsandmapsefficiency.dagger

import com.example.listsandmapsefficiency.dagger.module.SharedPreferencesModule
import com.example.listsandmapsefficiency.dagger.module.UtilModule
import com.example.listsandmapsefficiency.model.CalculationModel
import com.example.listsandmapsefficiency.ui.fragment.ListsFragment
import com.example.listsandmapsefficiency.ui.fragment.MapsFragment
import com.example.listsandmapsefficiency.viewmodel.ListsViewModel
import com.example.listsandmapsefficiency.viewmodel.MapsViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [UtilModule::class, SharedPreferencesModule::class])
@Singleton
interface AppComponent {
    fun inject(calculationModel: CalculationModel)
    fun inject(mapsViewModel: MapsViewModel)
    fun inject(listsViewModel: ListsViewModel)
    fun inject(mapsFragment: MapsFragment)
    fun inject(listsFragment: ListsFragment)
}