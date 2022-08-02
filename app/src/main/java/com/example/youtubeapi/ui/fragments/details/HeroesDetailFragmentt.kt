package com.example.youtubeapi.ui.fragments.details

import android.os.Bundle
import android.util.Log

import android.view.View
import android.widget.Toast

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4hw1.ui.fragments.details.HeroesDetailViewModel
import com.example.youtubeapi.Either
import com.example.youtubeapi.databinding.FragmentHeroesDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroesDetailFragmentt : BottomSheetDialogFragment(){

    private val binding by viewBinding(FragmentHeroesDetailBinding::bind)
    private val viewModel: HeroesDetailViewModel by viewModels()
    private val args by navArgs<HeroesDetailFragmenttArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        Toast.makeText(context, "You pressed on button ", Toast.LENGTH_SHORT).show()

        viewModel.fetchHeroesId(args.position).observe(viewLifecycleOwner) {
            when (it) {
                is Either.Left -> {
                    Log.e("anime", it.value.toString())
                }
                is Either.Right -> {
                    it.value.forEach { detailHeroModel ->
                        binding.nameDetailHeroes.text = detailHeroModel.leagueName
                    }
                }
            }
        }
    }
}