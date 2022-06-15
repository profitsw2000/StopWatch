package ru.profitsw2000.stopwatch.domain

import kotlinx.coroutines.flow.Flow

interface DataSource {
    val data: Flow<Long>
}