package com.margin.wine.wine

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.margin.wine.wine.databinding.ItemKnowledgeBinding
import com.margin.wine.wine.databinding.ItemWineBinding
import com.margin.wine.wine.databinding.ItemWineVerticalBinding
import com.margin.wine.wine.holder.KnowledgeViewHolder
import com.margin.wine.wine.holder.WineVerticalHolder
import com.margin.wine.wine.model.WineListUiModel
import com.margin.wine.wine.holder.WineViewHolder

class WineListAdapter(private val list: List<WineListUiModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int) = when(list[position]) {
        is WineListUiModel.WineList -> R.layout.item_wine
        is WineListUiModel.WineListVertical -> R.layout.item_wine_vertical
        is WineListUiModel.Knowledge -> R.layout.item_knowledge
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when(viewType) {
            R.layout.item_wine -> WineViewHolder(ItemWineBinding.inflate(layoutInflater, parent, false))
            R.layout.item_wine_vertical -> WineVerticalHolder(ItemWineVerticalBinding.inflate(layoutInflater, parent, false))
            R.layout.item_knowledge -> KnowledgeViewHolder(ItemKnowledgeBinding.inflate(layoutInflater, parent, false))

            else -> WineViewHolder(ItemWineBinding.inflate(layoutInflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(list[position]) {
            is WineListUiModel.WineList -> (holder as WineViewHolder).bind(list[position] as WineListUiModel.WineList)
            is WineListUiModel.WineListVertical -> (holder as WineVerticalHolder).bind(list[position] as WineListUiModel.WineListVertical)
            is WineListUiModel.Knowledge -> (holder as KnowledgeViewHolder).bind(list[position] as WineListUiModel.Knowledge)
        }
    }

    override fun getItemCount(): Int  = list.count()

}