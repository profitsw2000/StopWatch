package ru.profitsw2000.stopwatch.domain

import kotlinx.coroutines.flow.Flow
import ru.profitsw2000.stopwatch.data.local.entities.StopWatchStateHolder

interface Repository {
    val stopWatchData: Flow<StopWatchStateHolder>
}