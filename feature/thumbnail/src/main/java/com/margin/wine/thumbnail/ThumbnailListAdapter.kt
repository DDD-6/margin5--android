package com.margin.wine.thumbnail

import android.text.SpannableString
import android.text.Spanned
import android.text.style.ImageSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.margin.wine.thumbnail.databinding.ItemThumbnailBinding
import com.margin.wine.thumbnail.databinding.ItemThumbnailCardBinding

class ThumbnailListAdapter(
    private val list: List<ThumbnailViewState>,
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<ThumbnailListAdapter.ThumbnailViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (list[position].type) {
            ThumbnailType.NORMAL -> ThumbnailType.NORMAL.ordinal
            ThumbnailType.CARD -> ThumbnailType.CARD.ordinal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThumbnailViewHolder {
        return when (viewType) {
            ThumbnailType.NORMAL.ordinal -> ThumbnailBasicViewHolder(
                ItemThumbnailBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                onClick
            )
            ThumbnailType.CARD.ordinal -> ThumbnailCardViewHolder(
                ItemThumbnailCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                onClick
            )
            else -> throw Exception()
        }
    }

    override fun onBindViewHolder(holder: ThumbnailViewHolder, position: Int) {
        when (holder) {
            is ThumbnailBasicViewHolder -> holder.bind(list[position])
            is ThumbnailCardViewHolder -> holder.bind(list[position])
        }
    }

    override fun getItemCount(): Int = list.count()

    abstract class ThumbnailViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class ThumbnailBasicViewHolder(
        private val binding: ItemThumbnailBinding,
        private val onClick: (Int) -> Unit
    ) : ThumbnailViewHolder(binding.root) {

        private var id: Int = -1

        init {
            binding.root.setOnClickListener {
                onClick(id)
            }
        }

        fun bind(viewState: ThumbnailViewState) {
            id = viewState.id
            binding.text.text = viewState.title
            binding.date.text = viewState.date
        }
    }

    class ThumbnailCardViewHolder(
        private val binding: ItemThumbnailCardBinding,
        private val onClick: (Int) -> Unit
    ) : ThumbnailViewHolder(binding.root) {

        private var id: Int = -1

        init {
            binding.root.setOnClickListener {
                onClick(id)
            }
        }

        fun bind(viewState: ThumbnailViewState) {

            id = viewState.id
            binding.wineName.text = viewState.wineName
            binding.wineType.text = viewState.wineType

            binding.title.text = viewState.title
            binding.date.text = viewState.date
            binding.inputText.text = viewState.note

            //spannableText(viewState)
        }

        private fun spannableText(viewState: ThumbnailViewState) {
            val text = "사진 없이 글로 적는 와인노트. 사진 없이 글로 적는 와인 사진 없이 글로 적는 와인노트. 사진 없이 글로 적는 와인 사진 없이 글로 적는 와인노트. 사진 없이 글로 적는 와인 사진 없이 글로 적는 와인노트. 사진 없이 글로 적는 와인 사진 없이 글로 적는 와인노트. 사진 없이 글로 적는 와인 사진 없이 글로 적는 와인노트. 사진 없이 글로 적는 와인 사진 없이 글로 적는 와인노트. 사진 없이 글로 적는 와인 사진 없이 글로 적는 와인노트. 사진 없이 글로 적는 와인 사진 없이 글로 적는 와인노트. 사진 없이 글로 적는 와인 사진 없이 글로 적는 와인노트. 사진 없이 글로 적는 와인 사진 없이 글로 적는 와인노트. 사진 없이 글로 적는 와인 사진 없이 글로 적는 와인노트. 사진 없이 글로 적는 와인 사진 없이 글로 적는 와인노트. 사진 없이 글로 적는 와인 사진 없이 글로 적는 와인노트. 사진 없이 글로 적는 와인 사진 없이 글로 적는"
            val context = binding.root.context
            val image = ContextCompat.getDrawable(context, R.drawable.ic_man)!!
            image.setBounds(0, 0, image.intrinsicWidth, image.intrinsicHeight)

            val sb = SpannableString(text)
            val imageSpan = ImageSpan(image, ImageSpan.ALIGN_BOTTOM)

            sb.setSpan(imageSpan, text.length - 150, text.length -149, Spanned.SPAN_INCLUSIVE_INCLUSIVE)

            binding.inputText.text = sb
        }
    }
}