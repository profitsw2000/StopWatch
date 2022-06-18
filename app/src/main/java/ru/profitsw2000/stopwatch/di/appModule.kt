package ru.profitsw2000.stopwatch.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.profitsw2000.stopwatch.data.RepositoryImpl
import ru.profitsw2000.stopwatch.data.TimestampProviderImpl
import ru.profitsw2000.stopwatch.data.local.DataSourceLocal
import ru.profitsw2000.stopwatch.data.local.entities.ElapsedTimeCalculator
import ru.profitsw2000.stopwatch.data.local.entities.StopWatchStateCalculator
import ru.profitsw2000.stopwatch.data.local.entities.StopWatchStateHolder
import ru.profitsw2000.stopwatch.ui.MainViewModel
import ru.profitsw2000.stopwatch.utils.TimestampMillisecondsFormatter

val webModule = module {
    single<TimestampProviderImpl>(named("timestampProvider")) { TimestampProviderImpl() }
    single<DataSourceLocal>(named("dataSourceLocal")) { DataSourceLocal(get(named("timestampProvider"))) }
    single<ElapsedTimeCalculator>(named("elapsedTimeCalculator")) { ElapsedTimeCalculator(get(named("timestampProvider"))) }
    single<TimestampMillisecondsFormatter>(named("timestampMillisecondsFormatter")) { TimestampMillisecondsFormatter() }
    single<StopWatchStateCalculator>(named("stopWatchStateCalculator")) { StopWatchStateCalculator(get(named("timestampProvider")), get(named("elapsedTimeCalculator"))) }
    single<RepositoryImpl>(named("repository")) { RepositoryImpl(get(named("dataSourceLocal"))) }

    factory<StopWatchStateHolder>(named("stopWatchStateHolder")) { StopWatchStateHolder(
                                get(named("stopWatchStateCalculator")),
                                get(named("elapsedTimeCalculator")),
                                get(named("timestampMillisecondsFormatter"))) }
    factory { MainViewModel(get(named("repository"))) }
}
