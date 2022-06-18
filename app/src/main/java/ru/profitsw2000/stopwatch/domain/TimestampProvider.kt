package ru.profitsw2000.stopwatch.domain

interface TimestampProvider {
    fun getMilliseconds(): Long
}