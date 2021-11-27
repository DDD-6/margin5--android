package com.margin.wine.wine.holder

import androidx.recyclerview.widget.RecyclerView
import com.margin.wine.core.ext.won
import com.margin.wine.wine.databinding.ItemWineBinding
import com.margin.wine.wine.model.WineListUiModel

class WineViewHolder(private val binding: ItemWineBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(wine: WineListUiModel.WineList) = with(binding){
        wineInfo.name.text = wine.name
        wineInfo.nameEng.text = wine.nameEng
        wineInfo.infoMain.text = wine.country + " / " + wine.region + " / " + wine.type
        wineInfo.infoSub.text = wine.alcoholContent.toString() + "% / " + wine.ml + "ml / " + wine.price.won()
        img.setImageResource(wine.imgRes)
    }

}