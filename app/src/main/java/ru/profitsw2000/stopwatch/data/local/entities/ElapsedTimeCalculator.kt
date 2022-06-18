package ru.profitsw2000.stopwatch.data.local.entities

import ru.profitsw2000.stopwatch.data.StopWatchState
import ru.profitsw2000.stopwatch.data.TimestampProviderImpl

class ElapsedTimeCalculator (
    private val timestampProviderImpl: TimestampProviderImpl
) {
    fun calculate(state: StopWatchState.Running): Long {
        val currentTimestamp = timestampProviderImpl.getMilliseconds()
        val timePassedSinceStart = if (currentTimestamp > state.startTime) {
            currentTimestamp - state.startTime
        } else {
            0
        }
        return timePassedSinceStart + state.elapsedTime
    }
}