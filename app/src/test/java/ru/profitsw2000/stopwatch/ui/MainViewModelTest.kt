package ru.profitsw2000.stopwatch.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import ru.profitsw2000.TestCoroutineRule
import ru.profitsw2000.stopwatch.data.RepositoryImpl

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class MainViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var testCoroutineRule = TestCoroutineRule()

    private lateinit var mainViewModel: MainViewModel

    @Mock
    private lateinit var repository: RepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mainViewModel = MainViewModel(repository)
    }


}