package ru.profitsw2000.stopwatch.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import ru.profitsw2000.stopwatch.data.local.DataSourceLocal
import ru.profitsw2000.stopwatch.data.local.entities.StopWatchListOrchestrator
import ru.profitsw2000.stopwatch.domain.Repository

class RepositoryImpl(dataSourceLocal: DataSourceLocal) : Repository {

    private val coroutineScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    override val stopWatchListOrchestrator: StopWatchListOrchestrator = StopWatchListOrchestrator(
        dataSourceLocal.stopWatchStateHolderList, coroutineScope)
}