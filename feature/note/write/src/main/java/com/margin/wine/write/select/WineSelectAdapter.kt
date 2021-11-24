package com.margin.wine.write.select

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.margin.wine.write.databinding.ItemWineSelectBinding

class WineSelectAdapter(
    private var list: ArrayList<WineSelect>,
    private val onClick: (WineSelect) -> Unit
) : RecyclerView.Adapter<WineSelectViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WineSelectViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return WineSelectViewHolder(ItemWineSelectBinding.inflate(inflater, parent, false)) { position ->
            list.forEachIndexed { index, wineSelect ->
                if (index == position) {
                    list[index] = wineSelect.copy(checked = true)
                    onClick(wineSelect)
                } else {
                    list[index] = wineSelect.copy(checked = false)
                }
            }



            notifyDataSetChanged()
        }
    }

    override fun onBindViewHolder(holder: WineSelectViewHolder, position: Int) {
        holder.bind(position, list[position])
    }

    override fun getItemCount() = list.count()


}