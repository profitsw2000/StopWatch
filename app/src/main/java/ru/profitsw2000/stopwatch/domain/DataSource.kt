package ru.profitsw2000.stopwatch.domain

import ru.profitsw2000.stopwatch.data.local.entities.StopWatchStateHolder

interface DataSource {
    val stopWatchStateHolderList: List<StopWatchStateHolder>
}