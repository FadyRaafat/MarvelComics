package com.fady.marvelcomics.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.fady.marvelcomics.R
import com.fady.marvelcomics.api.models.SeriesResponse
import com.fady.marvelcomics.databinding.ItemSeriesBinding
import com.fady.marvelcomics.ui.common.DataBoundListAdapter

class SeriesAdapter(
) : DataBoundListAdapter<SeriesResponse.Data.Result, ItemSeriesBinding>
    (
    diffCallback = object : DiffUtil.ItemCallback<SeriesResponse.Data.Result>() {
        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: SeriesResponse.Data.Result,
            newItem: SeriesResponse.Data.Result
        ): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(
            oldItem: SeriesResponse.Data.Result,
            newItem: SeriesResponse.Data.Result
        ): Boolean {
            return oldItem == newItem
        }

    }
) {
    override fun createBinding(parent: ViewGroup): ItemSeriesBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_series,
            parent,
            false
        )
    }

    override fun bind(
        binding: ItemSeriesBinding,
        item: SeriesResponse.Data.Result,
        position: Int,
        adapterPosition: Int
    ) {
        binding.comic = item
    }

}