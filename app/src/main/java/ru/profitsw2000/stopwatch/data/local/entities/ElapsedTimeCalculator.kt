package ru.profitsw2000.stopwatch.data.local.entities

import ru.profitsw2000.stopwatch.data.StopWatchState

class ElapsedTimeCalculator (
    private val timestamp: Long,
) {
    fun calculate(state: StopWatchState.Running): Long {
        val currentTimestamp = timestamp
        val timePassedSinceStart = if (currentTimestamp > state.startTime) {
            currentTimestamp - state.startTime
        } else {
            0
        }
        return timePassedSinceStart + state.elapsedTime
    }
}