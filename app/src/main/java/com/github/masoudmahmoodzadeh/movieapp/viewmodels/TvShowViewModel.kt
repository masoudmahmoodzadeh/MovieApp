package com.github.masoudmahmoodzadeh.movieapp.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.masoudmahmoodzadeh.movieapp.models.Item
import com.github.masoudmahmoodzadeh.movieapp.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel
@Inject constructor
    (private val repository: TvShowRepository) : ViewModel() {

    private val _response = MutableLiveData<List<Item>>()

    val responseTvShow: LiveData<List<Item>>
        get() = _response

    init {


        getAllTvShow()
    }

    private fun getAllTvShow() = viewModelScope.launch {

        repository.getMovies().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body()?.items)
            } else
                Log.d("Error", "get all tv shows Error : ${response.code()}")
        }
    }

}