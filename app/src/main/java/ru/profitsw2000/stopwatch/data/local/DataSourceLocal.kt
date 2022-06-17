package ru.profitsw2000.stopwatch.data.local
import ru.profitsw2000.stopwatch.data.TimestampProviderImpl
import ru.profitsw2000.stopwatch.domain.DataSource

class DataSourceLocal(private val timestampProviderImpl: TimestampProviderImpl): DataSource {
    override fun getMillisecondsTime(): Long {
        return timestampProviderImpl.getMilliseconds()
    }
}