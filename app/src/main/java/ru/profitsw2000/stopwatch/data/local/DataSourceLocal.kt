package ru.profitsw2000.stopwatch.data.local

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.profitsw2000.stopwatch.data.TimestampProviderImpl
import ru.profitsw2000.stopwatch.domain.DataSource

class DataSourceLocal(private val timestampProviderImpl: TimestampProviderImpl): DataSource {
    override val data: Flow<Long> = flow {
        val timeFromDB = timestampProviderImpl.getMilliseconds()
        emit(timeFromDB)
        delay(20)
    }
        .flowOn(Dispatchers.Default)
        .catch { e ->
            println(e.message)//Error!
        }
}