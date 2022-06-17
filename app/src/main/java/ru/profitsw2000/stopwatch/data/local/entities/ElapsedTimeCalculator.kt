package ru.profitsw2000.stopwatch.data.local.entities

import ru.profitsw2000.stopwatch.data.StopWatchState
import ru.profitsw2000.stopwatch.data.local.DataSourceLocal

class ElapsedTimeCalculator (
    private val timeSourceLocal: DataSourceLocal
) {
    fun calculate(state: StopWatchState.Running): Long {
        val currentTimestamp = timeSourceLocal.getMillisecondsTime()
        val timePassedSinceStart = if (currentTimestamp > state.startTime) {
            currentTimestamp - state.startTime
        } else {
            0
        }
        return timePassedSinceStart + state.elapsedTime
    }
}