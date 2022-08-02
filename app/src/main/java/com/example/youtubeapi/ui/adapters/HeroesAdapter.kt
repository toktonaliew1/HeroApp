package com.example.android4hw1.ui.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

import com.example.android4hw1.models.HeroesModel
import com.example.youtubeapi.databinding.ItemHeroesBinding

import java.util.*
import kotlin.reflect.KFunction1

class HeroesAdapter(private val itemClick: KFunction1<Int, Unit>
) : androidx.recyclerview.widget.ListAdapter<HeroesModel, HeroesAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHeroesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemHeroesBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: HeroesModel) {
            binding.itemHeroesName.text = item.name

            binding.root.setOnClickListener {
                itemClick(item.id)
            }
        }
    }

    companion object {

        private val diffCallback: DiffUtil.ItemCallback<HeroesModel> =
            object : DiffUtil.ItemCallback<HeroesModel>() {
                override fun areItemsTheSame(
                    oldItem: HeroesModel,
                    newItem: HeroesModel
                ): Boolean {
                    return oldItem.id === newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(
                    oldItem: HeroesModel,
                    newItem: HeroesModel
                ): Boolean {
                    return oldItem === newItem
                }
            }
    }
}
