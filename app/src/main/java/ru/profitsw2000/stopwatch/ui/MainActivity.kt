package ru.profitsw2000.stopwatch.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.profitsw2000.stopwatch.R
import ru.profitsw2000.stopwatch.data.RepositoryImpl
import ru.profitsw2000.stopwatch.data.StopWatchState
import ru.profitsw2000.stopwatch.data.TimestampProviderImpl
import ru.profitsw2000.stopwatch.data.local.DataSourceLocal
import ru.profitsw2000.stopwatch.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val repositoryImpl = RepositoryImpl(DataSourceLocal(TimestampProviderImpl()))

    private val viewModel: MainViewModel by viewModels { ViewModelFactory(repositoryImpl) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.liveData0.observe(this@MainActivity) { renderData(it, 0)}
        viewModel.liveData1.observe(this@MainActivity) { renderData(it, 1)}

        initButtons()
    }

    private fun initButtons() {
        binding.startButton.setOnClickListener {
            viewModel.start(0)
        }

        binding.pauseButton.setOnClickListener {
            viewModel.pause(0)
        }

        binding.stopButton.setOnClickListener {
            viewModel.stop(0)
        }

        binding.startButton2.setOnClickListener {
            viewModel.start(1)
        }

        binding.pauseButton2.setOnClickListener {
            viewModel.pause(1)
        }

        binding.stopButton2.setOnClickListener {
            viewModel.stop(1)
        }
    }

    private fun renderData(text: String?, timerIndex: Int) {
        val timeText = if (!text.equals("")) text
                        else getString(R.string.start_time_text)

        when(timerIndex) {
            0 -> binding.timeTextView.text = timeText
            1 -> binding.time2TextView.text = timeText
            else -> {}
        }
    }
}
