package com.example.hilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.hilt.R
import com.example.hilt.databinding.ActivityMainBinding
import com.example.hilt.ui.firstfragment.FirstFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val viewModel : MainActivityViewModel  by viewModels()
    private lateinit var fetchJob : Job



    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        fetchJob = viewModel.fetchData()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, FirstFragment(), FirstFragment.TAG)
            .commit()
    }

    override fun onDestroy() {
        if(fetchJob.isActive){
            fetchJob.cancel()
        }

        super.onDestroy()
    }
}