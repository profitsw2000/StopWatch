package ru.profitsw2000.stopwatch.domain

import ru.profitsw2000.stopwatch.data.local.entities.StopWatchListOrchestrator

interface Repository {
    val stopWatchListOrchestrator: StopWatchListOrchestrator
}