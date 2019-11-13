package com.test.currencyconverter.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.currencyconverter.core.domain.RateList
import com.test.currencyconverter.core.domain.interactor.GetRatesUseCase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject


/**
 * Created by Hammad Akram
 * hamadakram91@gmail.com
 */

class RatesViewModel @Inject constructor(private val getRatesUseCase: GetRatesUseCase) :
    ViewModel() {

    enum class ListUpdateType {
        UPDATE_ALL, MOVE_TO_TOP
    }

    var listUpdateType = ListUpdateType.UPDATE_ALL
    var selectedCurrency: String = ""
    private val compositeDisposable = CompositeDisposable()

    val ratesLiveData = MutableLiveData<RateList>()
    val progressBarState = MutableLiveData<Boolean>().apply { this.value = true }


    var selectedPosition: Int = 0
        set(value) {
            field = value
            ratesLiveData.value?.let { rateList ->
                rateList.move(from = value, to = 0)
                // Update Single Item - Move to top
                updateList(
                    rateList,
                    ListUpdateType.MOVE_TO_TOP
                )
            }
        }

    fun updateRates(atPeriod: Long) {
        compositeDisposable.add(
            Observable.interval(0, atPeriod, TimeUnit.SECONDS)
                .flatMap {
                    getRatesUseCase.getRates(selectedCurrency).toObservable() }
                .repeat()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ remoteList ->
                    progressBarState.value = false

                    ratesLiveData.value?.let { localList ->
                        // Updating only Rates while keeping position
                        localList.updateRates(remoteList)
                        // Update All items
                        updateList(localList, ListUpdateType.UPDATE_ALL)
                    } ?: run {
                        // Update All items
                        updateList(remoteList, ListUpdateType.UPDATE_ALL)
                    }
                }, { it.printStackTrace() })
        )
    }

    private fun updateList(rates: RateList, listUpdateType: ListUpdateType) {
        this.listUpdateType = listUpdateType
        ratesLiveData.value = rates
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}