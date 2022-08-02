package com.example.android4hw1.data.remote.apiservices

import com.example.android4hw1.models.DetailHeroModel
import com.example.android4hw1.models.HeroesModel
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroesApiService {

    @GET("heroes")
    suspend fun fetchHeroes(): List<HeroesModel>

    @GET("heroes/{hero_id}/matches")
    suspend fun fetchHeroesId(
        @Path("hero_id") id: Int
    ): List<DetailHeroModel>
}