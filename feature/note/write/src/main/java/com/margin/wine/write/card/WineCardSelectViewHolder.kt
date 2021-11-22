package com.margin.wine.write.card

import androidx.recyclerview.widget.RecyclerView
import com.margin.wine.write.databinding.ItemWineCardSelectBinding

class WineCardSelectViewHolder(
    private val binding: ItemWineCardSelectBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: WineCardSelect) {
        binding.thumbnail.setImageResource(model.thumbnailRes)
    }
}