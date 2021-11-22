package com.margin.wine.write.card

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.margin.wine.write.databinding.ItemWineCardSelectBinding


class WineCardSelectAdapter : ListAdapter<WineCardSelect, WineCardSelectViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WineCardSelectViewHolder {
        return WineCardSelectViewHolder(ItemWineCardSelectBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: WineCardSelectViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<WineCardSelect>() {
            override fun areItemsTheSame(
                oldItem: WineCardSelect,
                newItem: WineCardSelect
            ): Boolean = oldItem.hashCode() == newItem.hashCode()

            override fun areContentsTheSame(
                oldItem: WineCardSelect,
                newItem: WineCardSelect
            ): Boolean = oldItem == newItem

        }
    }
}
data class WineCardSelect(
    @DrawableRes val thumbnailRes: Int
)