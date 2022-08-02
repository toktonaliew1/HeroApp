package com.example.android4hw1.data.repository

import androidx.lifecycle.liveData
import com.example.android4hw1.data.remote.apiservices.HeroesApiService
import com.example.youtubeapi.Either
import kotlinx.coroutines.Dispatchers
import java.io.IOException
import javax.inject.Inject

class HeroesRepository @Inject constructor(private val apiService: HeroesApiService) {

    fun fetchHeroes() = liveData (Dispatchers.IO) {
        try {
            emit(Either.Right(apiService.fetchHeroes()))
        } catch (ioException: IOException) {
            emit(Either.Left(ioException.localizedMessage))
        }
    }

    fun fetchHeroesId(id: Int) = liveData(Dispatchers.IO) {
        try {
            emit(Either.Right(apiService.fetchHeroesId(id = id)))
        } catch (ioException: IOException) {
            emit(Either.Left(ioException.localizedMessage))
        }
    }
}