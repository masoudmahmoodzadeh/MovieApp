package com.github.masoudmahmoodzadeh.movieapp

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.masoudmahmoodzadeh.movieapp.adapter.TvShowAdapter
import com.github.masoudmahmoodzadeh.movieapp.databinding.ActivityMainBinding
import com.github.masoudmahmoodzadeh.movieapp.viewmodels.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: TvShowViewModel by viewModels()
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        configRecyclerView()

        viewModel.responseTvShow.observe(this, {
            binding.filters.filters.visibility = View.VISIBLE
            binding.rvTv.visibility = View.VISIBLE
            binding.progressbar.visibility = View.GONE
            tvShowAdapter.tvShows = it
        })
    }

    private fun configRecyclerView() {

        tvShowAdapter = TvShowAdapter()

        binding.rvTv.apply {
            adapter = tvShowAdapter

            val orientation = resources.configuration.orientation
            layoutManager = if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                GridLayoutManager(this@MainActivity, 2)
            } else {
                LinearLayoutManager(this@MainActivity)
            }

            setHasFixedSize(true)

        }
    }

}