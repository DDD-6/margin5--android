package com.margin.wine.wine.holder

import androidx.recyclerview.widget.RecyclerView
import com.margin.wine.wine.databinding.ItemWineVerticalBinding
import com.margin.wine.wine.model.WineListUiModel

class WineVerticalHolder(private val binding: ItemWineVerticalBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: WineListUiModel.WineListVertical) = with(binding){
        title.text = model.title
        subTitle.text = model.subtitle

        wineInfo.text = model.country + " / " + model.region + " / " + model.type
        wineSubInfo.text = model.alcoholContent.toString() + "% / " + model.ml + " / " + model.price + "원"
    }

}