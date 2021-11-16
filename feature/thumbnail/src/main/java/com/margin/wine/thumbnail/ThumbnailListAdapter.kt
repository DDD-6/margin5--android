package com.margin.wine.thumbnail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.margin.wine.thumbnail.databinding.ItemThumbnailBinding

class ThumbnailListAdapter(
    private val list: List<ThumbnailViewState>
) : RecyclerView.Adapter<ThumbnailListAdapter.ThumbnailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThumbnailViewHolder {
        return ThumbnailViewHolder(ItemThumbnailBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ThumbnailViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.count()

    class ThumbnailViewHolder(private val binding: ItemThumbnailBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(viewState: ThumbnailViewState) {
            binding.viewState = viewState
        }
    }
}