package com.margin.wine.thumbnail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.margin.wine.thumbnail.databinding.ItemThumbnailBinding
import com.margin.wine.thumbnail.databinding.ItemThumbnailCardBinding

class ThumbnailListAdapter(
    private val list: List<ThumbnailViewState>
) : RecyclerView.Adapter<ThumbnailListAdapter.ThumbnailViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when(list[position].type) {
            ThumbnailType.NORMAL -> ThumbnailType.NORMAL.ordinal
            ThumbnailType.CARD -> ThumbnailType.CARD.ordinal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThumbnailViewHolder {
        return when(viewType) {
            ThumbnailType.NORMAL.ordinal -> ThumbnailBasicViewHolder(ItemThumbnailBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            ThumbnailType.CARD.ordinal -> ThumbnailCardViewHolder(ItemThumbnailCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw Exception()
        }
    }

    override fun onBindViewHolder(holder: ThumbnailViewHolder, position: Int) {
        when(holder) {
            is ThumbnailBasicViewHolder -> holder.bind(list[position])
            is ThumbnailCardViewHolder -> holder.bind(list[position])
        }
    }

    override fun getItemCount(): Int = list.count()

    abstract class ThumbnailViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class ThumbnailBasicViewHolder(private val binding: ItemThumbnailBinding): ThumbnailViewHolder(binding.root) {

        fun bind(viewState: ThumbnailViewState) {
            binding.text.text = viewState.title
            binding.date.text = viewState.date
        }
    }

    class ThumbnailCardViewHolder(private val binding: ItemThumbnailCardBinding): ThumbnailViewHolder(binding.root) {

        fun bind(viewState: ThumbnailViewState) {
            binding.wineName.text = viewState.wineName
            binding.wineType.text = viewState.wineType
            binding.text.text = viewState.title
            binding.date.text = viewState.date
        }
    }


}