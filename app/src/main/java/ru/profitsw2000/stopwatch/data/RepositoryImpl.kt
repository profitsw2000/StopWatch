package ru.profitsw2000.stopwatch.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import ru.profitsw2000.stopwatch.data.local.DataSourceLocal
import ru.profitsw2000.stopwatch.data.local.entities.ElapsedTimeCalculator
import ru.profitsw2000.stopwatch.data.local.entities.StopWatchStateCalculator
import ru.profitsw2000.stopwatch.data.local.entities.StopWatchStateHolder
import ru.profitsw2000.stopwatch.domain.DataSource
import ru.profitsw2000.stopwatch.domain.Repository
import ru.profitsw2000.stopwatch.utils.TimestampMillisecondsFormatter

class RepositoryImpl(dataSource: DataSource = DataSourceLocal(TimestampProviderImpl())) : Repository {

    override val stopWatchData: Flow<StopWatchStateHolder> = dataSource.data.map {
        StopWatchStateHolder(StopWatchStateCalculator(it, ElapsedTimeCalculator(it)),
                            ElapsedTimeCalculator(it),
                            TimestampMillisecondsFormatter())
    }
}