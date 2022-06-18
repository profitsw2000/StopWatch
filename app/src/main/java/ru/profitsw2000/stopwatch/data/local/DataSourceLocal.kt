package ru.profitsw2000.stopwatch.data.local
import ru.profitsw2000.stopwatch.data.TimestampProviderImpl
import ru.profitsw2000.stopwatch.data.local.entities.ElapsedTimeCalculator
import ru.profitsw2000.stopwatch.data.local.entities.StopWatchStateCalculator
import ru.profitsw2000.stopwatch.data.local.entities.StopWatchStateHolder
import ru.profitsw2000.stopwatch.domain.DataSource
import ru.profitsw2000.stopwatch.utils.TimestampMillisecondsFormatter

class DataSourceLocal(timestampProviderImpl: TimestampProviderImpl): DataSource {

    private val elapsedTimeCalculator = ElapsedTimeCalculator(timestampProviderImpl)
    private val timestampMillisecondsFormatter = TimestampMillisecondsFormatter()
    private val stopWatchStateCalculator = StopWatchStateCalculator(timestampProviderImpl, elapsedTimeCalculator)

    private val stopWatchStateHolder1 = StopWatchStateHolder(
        stopWatchStateCalculator,
        elapsedTimeCalculator,
        timestampMillisecondsFormatter)

    private val stopWatchStateHolder2 = StopWatchStateHolder(
        stopWatchStateCalculator,
        elapsedTimeCalculator,
        timestampMillisecondsFormatter)

    override val stopWatchStateHolderList: List<StopWatchStateHolder> =
        arrayListOf(stopWatchStateHolder1, stopWatchStateHolder2)
}