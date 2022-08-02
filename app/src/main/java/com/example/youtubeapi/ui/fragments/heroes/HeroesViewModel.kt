package com.example.android4hw1.ui.fragments.heroes

import androidx.lifecycle.ViewModel
import com.example.android4hw1.base.BaseViewModel
import com.example.android4hw1.data.repository.HeroesRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HeroesViewModel @Inject constructor(private val repository: HeroesRepository) :
    BaseViewModel() {

    fun fetchHeroes() = repository.fetchHeroes()
}