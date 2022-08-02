package com.example.android4hw1.data.remote

import com.example.android4hw1.data.remote.apiservices.HeroesApiService
import com.example.android4hw1.data.remote.apiservices.OkHttp
import com.example.android4hw1.data.remote.apiservices.RetrofitClient
import javax.inject.Inject

class NetWorkClient @Inject constructor(
    retrofitClient: RetrofitClient,
    okHttpClient: OkHttp
) {

    private val provideRetrofit = retrofitClient.provideRetrofit(okHttpClient.provideOkHttpClient())

    fun provideHeroesApiService() = provideRetrofit.create(HeroesApiService::class.java)
}