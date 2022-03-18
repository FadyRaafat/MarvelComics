package com.fady.marvelcomics.ui.adapters

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import com.fady.marvelcomics.R
import com.fady.marvelcomics.api.models.CharactersResponse
import com.fady.marvelcomics.databinding.ItemCharacterBinding
import com.fady.marvelcomics.ui.common.BaseBindingPagingAdapter
import com.fady.marvelcomics.ui.utils.NetworkState
import com.fady.marvelcomics.ui.utils.SingleLiveEvent
import com.fady.marvelcomics.ui.utils.ViewUtils

class CharactersPagingAdapter(
    context: Context,
    networkStatusMutable: SingleLiveEvent<NetworkState>,
    onclick: (CharactersResponse.Data.Result) -> Unit
) : BaseBindingPagingAdapter<CharactersResponse.Data.Result, ItemCharacterBinding>(
    context,
    networkStatusMutable,
    R.layout.item_character,
    onItemClick = onclick,
    diffCallback = object :
        DiffUtil.ItemCallback<CharactersResponse.Data.Result>() {
        override fun areContentsTheSame(
            oldItem: CharactersResponse.Data.Result,
            newItem: CharactersResponse.Data.Result
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areItemsTheSame(
            oldItem: CharactersResponse.Data.Result,
            newItem: CharactersResponse.Data.Result
        ): Boolean {
            return oldItem.id == newItem.id
        }

    }
) {
    override fun bind(
        binding: ItemCharacterBinding,
        item: CharactersResponse.Data.Result,
        adapterPosition: Int
    ) {
        binding.item = item
        if (item.thumbnail != null) {
            item.thumbnail?.let {
                binding.imageUrl = ViewUtils.formatImageUrl(it)
            }
        }
    }

}