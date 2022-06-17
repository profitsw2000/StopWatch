package ru.profitsw2000.stopwatch.domain

interface DataSource {
    fun getMillisecondsTime(): Long
}