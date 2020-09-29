package com.example.listsandmapsefficiency.viewmodel

import com.example.listsandmapsefficiency.interfaces.CalculationListener
import com.example.listsandmapsefficiency.model.CalculationModel
import com.example.listsandmapsefficiency.util.Constants
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ListsViewModelTest {

    private val defaultSize = 1000000

    @Mock
    lateinit var mockedModel: CalculationModel

    var mViewModel: ListsViewModel = ListsViewModel()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mViewModel.mModel = mockedModel
    }

    @Test
    fun testStartCalculation() {
        mViewModel.startCalculation(Constants.listOfListsKeys, defaultSize)
        Mockito.verify(mockedModel).startCalculation(Constants.listOfListsKeys[0], defaultSize)
    }
}