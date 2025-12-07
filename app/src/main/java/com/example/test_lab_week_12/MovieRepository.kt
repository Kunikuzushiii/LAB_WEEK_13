package com.example.test_lab_week_12

import com.example.test_lab_week_12.api.MovieService
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.example.test_lab_week_12.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieRepository(private val movieService: MovieService) {
    private val apiKey = "17a599d04830d82a43ece97249a302dc"

    fun fetchMovies(): Flow<List<Movie>> {
        return flow {
            emit(movieService.getPopularMovies(apiKey).results)
        }.flowOn(Dispatchers.IO)
    }
}