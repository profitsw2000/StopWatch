package ru.profitsw2000.stopwatch.data.local.entities

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StopWatchListOrchestrator(
    private val stopWatchStateHolderList: List<StopWatchStateHolder>,
    private val scope: CoroutineScope,
) {
    private var jobList: MutableList<Job?> = mutableListOf(null,null)
    private val mutableTickerList: List<MutableStateFlow<String>> = arrayListOf(MutableStateFlow(""), MutableStateFlow(""))
    val tickerList: List<StateFlow<String>> = mutableTickerList

    fun start(timerIndex: Int) {
        if (jobList[timerIndex] == null) startJob(timerIndex)
        stopWatchStateHolderList[timerIndex].start()
    }

    private fun startJob(timerIndex: Int) {
        scope.launch {
            while (isActive) {
                mutableTickerList[timerIndex].value = stopWatchStateHolderList[timerIndex].getStringTimeRepresentation()
                delay(20)
            }
        }
    }

    fun pause(timerIndex: Int) {
        stopWatchStateHolderList[timerIndex].pause()
        stopJob(timerIndex)
    }

    fun stop(timerIndex: Int) {
        stopWatchStateHolderList[timerIndex].stop()
        stopJob(timerIndex)
        clearValue(timerIndex)
    }

    private fun stopJob(timerIndex: Int) {
        jobList[timerIndex] = null
    }

    private fun clearValue(timerIndex: Int) {
        mutableTickerList[timerIndex].value = "00:00:000"
    }
}