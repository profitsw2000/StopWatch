package ru.profitsw2000.stopwatch.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import ru.profitsw2000.stopwatch.data.RepositoryImpl


class MainViewModel(private val repository: RepositoryImpl) {

    val liveData: LiveData<String> = repository.stopWatchListOrchestrator.ticker.asLiveData()

    fun start() {
        repository.stopWatchListOrchestrator.start()
    }

    fun stop() {
        repository.stopWatchListOrchestrator.stop()
    }

    fun pause() {
        repository.stopWatchListOrchestrator.pause()
    }
}