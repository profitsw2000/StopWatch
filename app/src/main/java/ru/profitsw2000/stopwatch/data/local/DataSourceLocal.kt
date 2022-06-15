package ru.profitsw2000.stopwatch.data.local

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.profitsw2000.stopwatch.data.TimestampProviderImpl
import ru.profitsw2000.stopwatch.domain.DataSource

class DataSourceLocal(private val timestampProviderImpl: TimestampProviderImpl): DataSource {
    override val data: Flow<Long> = flow {
        val timeFromDB = timestampProviderImpl.getMilliseconds()
        emit(timeFromDB)
        delay(20)
    }
}