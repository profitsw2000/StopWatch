package ru.profitsw2000.stopwatch.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import ru.profitsw2000.stopwatch.data.local.DataSourceLocal
import ru.profitsw2000.stopwatch.data.local.entities.ElapsedTimeCalculator
import ru.profitsw2000.stopwatch.data.local.entities.StopWatchListOrchestrator
import ru.profitsw2000.stopwatch.data.local.entities.StopWatchStateCalculator
import ru.profitsw2000.stopwatch.data.local.entities.StopWatchStateHolder
import ru.profitsw2000.stopwatch.domain.DataSource
import ru.profitsw2000.stopwatch.domain.Repository
import ru.profitsw2000.stopwatch.utils.TimestampMillisecondsFormatter

class RepositoryImpl(dataSourceLocal: DataSourceLocal) : Repository {

    private val coroutineScope = CoroutineScope(Dispatchers.Main + SupervisorJob())
/*    private val elapsedTimeCalculator = ElapsedTimeCalculator(dataSourceLocal)
    private val timestampMillisecondsFormatter = TimestampMillisecondsFormatter()
    private val stopWatchStateCalculator = StopWatchStateCalculator(dataSourceLocal, elapsedTimeCalculator)

    private val stopWatchStateHolder1 = StopWatchStateHolder(
                                            stopWatchStateCalculator,
                                            elapsedTimeCalculator,
                                            timestampMillisecondsFormatter)

    private val stopWatchStateHolder2 = StopWatchStateHolder(
        stopWatchStateCalculator,
        elapsedTimeCalculator,
        timestampMillisecondsFormatter)*/

    override val stopWatchListOrchestrator: StopWatchListOrchestrator = StopWatchListOrchestrator(
        dataSourceLocal.stopWatchStateHolderList, coroutineScope)
}