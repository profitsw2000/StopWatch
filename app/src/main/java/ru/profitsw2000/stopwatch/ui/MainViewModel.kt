package ru.profitsw2000.stopwatch.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import ru.profitsw2000.stopwatch.data.RepositoryImpl


class MainViewModel(private val repository: RepositoryImpl) : ViewModel() {

    val liveData0: LiveData<String> = repository.stopWatchListOrchestrator.tickerList[0].asLiveData()
    val liveData1: LiveData<String> = repository.stopWatchListOrchestrator.tickerList[1].asLiveData()

    fun start(timerIndex: Int) {
        repository.stopWatchListOrchestrator.start(timerIndex)
    }

    fun stop(timerIndex: Int) {
        repository.stopWatchListOrchestrator.stop(timerIndex)
    }

    fun pause(timerIndex: Int) {
        repository.stopWatchListOrchestrator.pause(timerIndex)
    }
}