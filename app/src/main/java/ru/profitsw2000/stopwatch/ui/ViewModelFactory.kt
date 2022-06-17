package ru.profitsw2000.stopwatch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.profitsw2000.stopwatch.data.RepositoryImpl
import ru.profitsw2000.stopwatch.domain.Repository

class ViewModelFactory (private val repository: RepositoryImpl) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}