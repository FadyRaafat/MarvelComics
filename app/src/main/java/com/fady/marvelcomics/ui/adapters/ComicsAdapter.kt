package com.fady.marvelcomics.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.fady.marvelcomics.R
import com.fady.marvelcomics.api.models.ComicsResponse
import com.fady.marvelcomics.databinding.ItemComicBinding
import com.fady.marvelcomics.ui.common.DataBoundListAdapter

class ComicsAdapter(
) : DataBoundListAdapter<ComicsResponse.Data.Result, ItemComicBinding>
    (
    diffCallback = object : DiffUtil.ItemCallback<ComicsResponse.Data.Result>() {
        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: ComicsResponse.Data.Result,
            newItem: ComicsResponse.Data.Result
        ): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(
            oldItem: ComicsResponse.Data.Result,
            newItem: ComicsResponse.Data.Result
        ): Boolean {
            return oldItem == newItem
        }

    }
) {
    override fun createBinding(parent: ViewGroup): ItemComicBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_comic,
            parent,
            false
        )
    }

    override fun bind(
        binding: ItemComicBinding,
        item: ComicsResponse.Data.Result,
        position: Int,
        adapterPosition: Int
    ) {
        binding.comic = item
    }

}