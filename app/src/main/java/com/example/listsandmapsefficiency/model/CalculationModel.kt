package com.example.listsandmapsefficiency.model

import com.example.listsandmapsefficiency.App
import com.example.listsandmapsefficiency.interfaces.CalculationListener
import com.example.listsandmapsefficiency.util.Calculation
import com.example.listsandmapsefficiency.util.Counter
import com.example.listsandmapsefficiency.util.LoggerImpl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CalculationModel(private val mCallback: CalculationListener) {

    companion object {
        private val TAG = CalculationModel::class.simpleName
    }

    private val logger = LoggerImpl()

    @Inject
    lateinit var counter: Counter

    init {
        App.appComponent.inject(this)
    }

    fun startCalculation(
        operation: String,
        size: Int
    ) {
        val mObservable = getObservable(size, operation)
        val mObserver = getObserver()

        mObservable.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.single())
            .subscribeWith(mObserver)
    }

    private fun getObserver(): Observer<ArrayList<String>> =
        object : Observer<ArrayList<String>> {
            override fun onSubscribe(d: Disposable?) {
                logger.logD(TAG, "onSubscribe")
            }

            override fun onNext(resultList: ArrayList<String>) {
                logger.logD(TAG, "onNext: $resultList")
                counter.increase()
                mCallback.receiveResult(resultList)
            }

            override fun onError(e: Throwable?) {
                logger.logE(TAG, "onError: ${e?.message}")
            }

            override fun onComplete() {
                logger.logD(TAG, "onComplete")
            }
        }


    private fun getObservable(
        size: Int,
        codeOperation: String
    ): Observable<ArrayList<String>> =
        Observable.create {
            if (!it.isDisposed) {
                it.onNext(Calculation().calculate(size, codeOperation))
                it.onComplete()
            }
        }
}