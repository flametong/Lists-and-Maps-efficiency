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

class ListsViewModel : ViewModel(), CalculationListener {

    var mModel = CalculationModel(this)

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
            Constants.KEY_CALC_LIST_1 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_1, currentMillis)
                postData(position = 0, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_2 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_2, currentMillis)
                postData(position = 1, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_3 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_3, currentMillis)
                postData(position = 2, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_4 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_4, currentMillis)
                postData(position = 3, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_5 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_5, currentMillis)
                postData(position = 5, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_6 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_6, currentMillis)
                postData(position = 6, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_7 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_7, currentMillis)
                postData(position = 7, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_8 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_8, currentMillis)
                postData(position = 8, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_9 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_9, currentMillis)
                postData(position = 9, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_10 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_10, currentMillis)
                postData(position = 10, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_11 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_11, currentMillis)
                postData(position = 11, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_12 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_12, currentMillis)
                postData(position = 12, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_13 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_13, currentMillis)
                postData(position = 13, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_14 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_14, currentMillis)
                postData(position = 14, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_15 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_15, currentMillis)
                postData(position = 15, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_16 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_16, currentMillis)
                postData(position = 16, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_17 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_17, currentMillis)
                postData(position = 16, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_18 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_18, currentMillis)
                postData(position = 17, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_19 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_19, currentMillis)
                postData(position = 18, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_20 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_20, currentMillis)
                postData(position = 19, currentMillis = currentMillis.toInt())
            }
            Constants.KEY_CALC_LIST_21 -> {
                sharedPref.saveData(Constants.KEY_CALC_LIST_21, currentMillis)
                postData(position = 20, currentMillis = currentMillis.toInt())
            }
        }

        try {
            println("counter: ${counter.getCount()}")
            if (counter.getCount() == Constants.LISTS_MAX_VALUE) {
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