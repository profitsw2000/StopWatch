package ru.profitsw2000.stopwatch.data

import ru.profitsw2000.stopwatch.domain.TimestampProvider

class TimestampProviderImpl : TimestampProvider {
    override fun getMilliseconds(): Long {
        return System.currentTimeMillis()
    }
}