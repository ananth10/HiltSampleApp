package com.ananth.hiltsampleapp.stats

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Runnable
import javax.inject.Inject


@HiltViewModel
class StatsViewModel @Inject constructor() : ViewModel() {

    val statsLiveData = MutableLiveData<Int>()
    var i = 0
    var runnable: Runnable? = null

    fun startStatsCollection() {
        val handler = Handler(Looper.getMainLooper())
        runnable = Runnable {
            statsLiveData.value = i++
            handler.postDelayed(runnable!!, 500)
        }
        handler.postDelayed(runnable!!,500)
    }
}