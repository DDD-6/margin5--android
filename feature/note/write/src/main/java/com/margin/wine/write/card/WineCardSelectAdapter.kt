package com.margin.wine.write.card

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.margin.wine.write.R
import com.margin.wine.write.databinding.ItemWineCardSelectBinding
import com.margin.wine.write.select.WineSelect


class WineCardSelectAdapter(
    private var list: ArrayList<WineCardSelect>,
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<WineCardSelectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WineCardSelectViewHolder {
        return WineCardSelectViewHolder(
            binding = ItemWineCardSelectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ) { position ->
            list.forEachIndexed { index, wineCardSelect ->
                if (index == position) {
                    list[index] = wineCardSelect.copy(isSelected = true)
                    onClick(index + 1)
                } else {
                    list[index] = wineCardSelect.copy(isSelected = false)
                }
            }

            notifyDataSetChanged()
        }
    }

    override fun onBindViewHolder(holder: WineCardSelectViewHolder, position: Int) {
        holder.bind(position, list[position])
    }

    override fun getItemCount(): Int = list.count()

    companion object {
        fun cardsRes() = arrayListOf(
            WineCardSelect(R.drawable.ic_man_select, R.drawable.ic_man_unselect, true),
            WineCardSelect(R.drawable.ic_woman_select, R.drawable.ic_woman_unselect),
            WineCardSelect(R.drawable.ic_couple_select, R.drawable.ic_couple_unselect),
            WineCardSelect(R.drawable.ic_mans_select, R.drawable.ic_mans_unselect),
            WineCardSelect(R.drawable.ic_womans_select, R.drawable.ic_womans_unselect)
        )
    }
}
data class WineCardSelect(
    @DrawableRes val thumbnailResSelect: Int,
    @DrawableRes val thumbnailResUnSelect: Int,
    var isSelected: Boolean = false
)