package com.margin.wine.write.card

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.margin.wine.write.R
import com.margin.wine.write.databinding.ItemWineCardSelectBinding

class WineCardSelectViewHolder(
    private val binding: ItemWineCardSelectBinding,
    private val onClick: (Int) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    var selectedPosition: Int = 0

    init {
        binding.thumbnail.setOnClickListener { onClick(selectedPosition) }
    }

    fun bind(position: Int, model: WineCardSelect) {
        selectedPosition = position
        val context = binding.root.context
        if (model.isSelected) {
            binding.root.background = ContextCompat.getDrawable(context, R.drawable.bg_select_card)
        } else {
            binding.root.background = ContextCompat.getDrawable(context, R.drawable.bg_unselect_card)
        }
        binding.thumbnail.setImageResource(model.thumbnailResSelect)
    }
}