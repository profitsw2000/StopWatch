package ru.profitsw2000.stopwatch.data.local.entities

import ru.profitsw2000.stopwatch.data.StopWatchState
import ru.profitsw2000.stopwatch.data.local.DataSourceLocal

class StopWatchStateCalculator (
    private val timeSourceLocal: DataSourceLocal,
    private val elapsedTimeCalculator: ElapsedTimeCalculator
) {
    fun calculateRunningState(oldState: StopWatchState): StopWatchState.Running =
        when (oldState) {
            is StopWatchState.Running -> oldState
            is StopWatchState.Paused -> {
                StopWatchState.Running(
                    startTime = timeSourceLocal.getMillisecondsTime(),
                    elapsedTime = oldState.elapsedTime
                )
            }
        }

    fun calculatePausedState(oldState: StopWatchState): StopWatchState.Paused =
        when (oldState) {
            is StopWatchState.Running -> {
                val elapsedTime = elapsedTimeCalculator.calculate(oldState)
                StopWatchState.Paused(elapsedTime = elapsedTime)
            }
            is StopWatchState.Paused -> oldState
        }
}
