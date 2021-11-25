package com.margin.wine.note.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.margin.wine.note.detail.databinding.ItemNoteImageBinding

class ImagePagerAdapter(
    private val images: List<String>
) : RecyclerView.Adapter<ImagePagerAdapter.ImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ImageViewHolder(ItemNoteImageBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = images.count()
    class ImageViewHolder(private val binding: ItemNoteImageBinding) : RecyclerView.ViewHolder(binding.root){

    }
}