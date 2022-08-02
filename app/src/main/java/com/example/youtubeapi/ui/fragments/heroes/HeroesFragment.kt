package com.example.android4hw1.ui.fragments.heroes


import android.util.Log

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding

import com.example.android4hw1.base.BaseFragment

import com.example.android4hw1.ui.adapters.HeroesAdapter
import com.example.youtubeapi.Either
import com.example.youtubeapi.R
import com.example.youtubeapi.databinding.FragmentHeroesBinding

import com.example.youtubeapi.ui.fragments.details.HeroesDetailFragmentt

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroesFragment :  BaseFragment<HeroesViewModel, FragmentHeroesBinding>(R.layout.fragment_heroes) {


    override val binding by viewBinding(FragmentHeroesBinding::bind)
    override val viewModel: HeroesViewModel by viewModels()
    private val heroesAdapter = HeroesAdapter(
        this::onItemClick
    )

    override fun initialize() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() = with(binding.recyclerHeroes) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = heroesAdapter
    }

    override fun setupSubscribes() {
        setupObserv()
    }

    private fun setupObserv() {
        viewModel.fetchHeroes().observe(viewLifecycleOwner) {
            when (it) {
                is Either.Left -> {
                    Log.e("anime", it.value)
                }
                is Either.Right -> {
                    Log.e("Anime", it.value.toString())
                    heroesAdapter.submitList(it.value)
                }
            }
        }
    }


    private fun onItemClick(id: Int) {
        findNavController().navigate(
            HeroesFragmentDirections.actionHeroesFragmentToHeroesDetailFragmentt(
                position = id
            )
        )
        val bottomSheeat = HeroesDetailFragmentt()
        bottomSheeat.show(parentFragmentManager, "Bottom Dialog")

    }
}



