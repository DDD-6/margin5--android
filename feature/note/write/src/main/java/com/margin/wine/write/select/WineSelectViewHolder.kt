package com.margin.wine.write.select

import android.graphics.Color
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.margin.wine.write.R
import com.margin.wine.write.databinding.ItemWineSelectBinding

class WineSelectViewHolder(
    private val binding: ItemWineSelectBinding,
    private val onClick: (Int) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    var index: Int = -1

    init {
        binding.root.setOnClickListener {
            onClick(index)
        }
    }

    fun bind(position: Int, model: WineSelect) {
        val context = binding.root.context
        binding.text.background = AppCompatResources.getDrawable(
            context,
            if (model.checked) R.drawable.bg_wine_select_on
            else R.drawable.bg_wine_select_off
        )
        binding.text.setTextColor(
            if (model.checked) Color.WHITE
            else ContextCompat.getColor(context, R.color.color_333333)
        )
        index = position
        binding.text.text = model.text
    }
}