package com.margin.wine.wine.holder

import androidx.recyclerview.widget.RecyclerView
import com.margin.wine.wine.databinding.ItemKnowledgeBinding
import com.margin.wine.wine.model.WineListUiModel

class KnowledgeViewHolder(
    private val binding: ItemKnowledgeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: WineListUiModel.Knowledge) = with(binding){
        title.text = model.title
        circleHead.text = model.header
        desc.text = model.desc
    }
}