package ru.profitsw2000.stopwatch.data.local
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named
import ru.profitsw2000.stopwatch.data.local.entities.StopWatchStateHolder
import ru.profitsw2000.stopwatch.domain.DataSource

class DataSourceLocal: DataSource, KoinComponent {

    private val stopWatchStateHolder1: StopWatchStateHolder by inject(named("stopWatchStateHolder"))
    private val stopWatchStateHolder2: StopWatchStateHolder by inject(named("stopWatchStateHolder"))

    override val stopWatchStateHolderList: List<StopWatchStateHolder> =
        arrayListOf(stopWatchStateHolder1, stopWatchStateHolder2)
}