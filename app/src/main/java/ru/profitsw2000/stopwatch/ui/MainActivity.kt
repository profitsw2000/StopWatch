package ru.profitsw2000.stopwatch.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.profitsw2000.stopwatch.R
import ru.profitsw2000.stopwatch.data.RepositoryImpl
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
        viewModel.liveData.observe(this@MainActivity) { renderData(it)}

        binding.startButton.setOnClickListener {
            viewModel.start()
        }

        binding.pauseButton.setOnClickListener {
            viewModel.pause()
        }

        binding.stopButton.setOnClickListener {
            viewModel.stop()
        }
    }

    private fun renderData(it: String?) {
        if (!it.equals("")) {
            binding.timeTextView.text = it
        } else {
            binding.timeTextView.text = getString(R.string.start_time_text)
        }
    }
}
