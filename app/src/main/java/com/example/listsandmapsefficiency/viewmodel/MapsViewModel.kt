package com.example.listsandmapsefficiency.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listsandmapsefficiency.App
import com.example.listsandmapsefficiency.interfaces.CalculationListener
import com.example.listsandmapsefficiency.model.CalculationModel
import com.example.listsandmapsefficiency.repository.CustomSharedPreferences
import com.example.listsandmapsefficiency.util.Constants
import com.example.listsandmapsefficiency.util.Counter
import com.example.listsandmapsefficiency.util.LoadingState
import com.google.common.collect.ImmutableList
import javax.inject.Inject

class MapsViewModel : ViewModel(), CalculationListener {

    private val mModel = CalculationModel(this)

    private val resultListData = MutableLiveData<ArrayList<Int>>()
    private val _loadingState = MutableLiveData<LoadingState>()

    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    @Inject
    lateinit var counter: Counter

    @Inject
    lateinit var sharedPref: CustomSharedPreferences

    init {
        App.appComponent.inject(this)
    }

    fun getResultListData(): LiveData<ArrayList<Int>> = resultListData

    fun startCalculation(
        operationList: ImmutableList<String>,
        size: Int
    ) {
        _loadingState.value = LoadingState.LOADING
        for (i in 0 until operationList.size) {
            mModel.startCalculation(operationList[i], size)
        }
    }

    override fun receiveResult(resultList: ArrayList<String>) {
        val currentMillis = resultList[0]

        when (resultList[1]) {
            Constants.KEY_CALC_MAP_1 -> {
                sharedPref.saveData(Constants.KEY_CALC_MAP_1, currentMillis)
                postData(position = 0, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_MAP_2 -> {
                sharedPref.saveData(Constants.KEY_CALC_MAP_2, currentMillis)
                postData(position = 1, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_MAP_3 -> {
                sharedPref.saveData(Constants.KEY_CALC_MAP_3, currentMillis)
                postData(position = 2, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_MAP_4 -> {
                sharedPref.saveData(Constants.KEY_CALC_MAP_4, currentMillis)
                postData(position = 3, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_MAP_5 -> {
                sharedPref.saveData(Constants.KEY_CALC_MAP_5, currentMillis)
                postData(position = 4, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_MAP_6 -> {
                sharedPref.saveData(Constants.KEY_CALC_MAP_6, currentMillis)
                postData(position = 5, currentMillis = currentMillis.toInt())
            }
        }

        try {
            if (counter.getCount() == Constants.MAPS_MAX_VALUE) {
                _loadingState.value = LoadingState.LOADED
                counter.reset()
            }
        } catch (e: Exception) {
            _loadingState.value = LoadingState.error(e.message)
        }
    }

    private fun postData(position: Int, currentMillis: Int) {
        val postValueList = ArrayList<Int>()
        postValueList.add(position)
        postValueList.add(currentMillis)
        resultListData.postValue(postValueList)
    }
}