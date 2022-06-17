package ru.profitsw2000.stopwatch.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import ru.profitsw2000.stopwatch.data.local.DataSourceLocal
import ru.profitsw2000.stopwatch.data.local.entities.ElapsedTimeCalculator
import ru.profitsw2000.stopwatch.data.local.entities.StopWatchListOrchestrator
import ru.profitsw2000.stopwatch.data.local.entities.StopWatchStateCalculator
import ru.profitsw2000.stopwatch.data.local.entities.StopWatchStateHolder
import ru.profitsw2000.stopwatch.domain.Repository
import ru.profitsw2000.stopwatch.utils.TimestampMillisecondsFormatter

class RepositoryImpl(private val dataSourceLocal: DataSourceLocal) : Repository {

    private val timestamp = dataSourceLocal.getMillisecondsTime()
    private val timestampMillisecondsFormatter = TimestampMillisecondsFormatter()
    private val elapsedTimeCalculator = ElapsedTimeCalculator(timestamp)
    private val stopWatchStateCalculator = StopWatchStateCalculator(timestamp, elapsedTimeCalculator)
    private val stopWatchStateHolder = StopWatchStateHolder(stopWatchStateCalculator, elapsedTimeCalculator, timestampMillisecondsFormatter)
    private val coroutineScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    override val stopWatchListOrchestrator: StopWatchListOrchestrator = StopWatchListOrchestrator(stopWatchStateHolder, coroutineScope)

}