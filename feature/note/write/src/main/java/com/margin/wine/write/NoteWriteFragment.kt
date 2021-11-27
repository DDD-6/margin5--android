package com.margin.wine.write

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.github.dhaval2404.imagepicker.ImagePicker
import com.margin.wine.core.ext.currentDate
import com.margin.wine.core.ext.toast
import com.margin.wine.write.card.WineCardSelectAdapter
import com.margin.wine.write.databinding.FragmentNoteWriteBinding
import com.margin.wine.write.select.WineSelect
import com.margin.wine.write.select.WineSelectAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class NoteWriteFragment : Fragment() {

    private val noteWriteViewModel by viewModels<NoteWriteViewModel>()
    private val binding by lazy { FragmentNoteWriteBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listCard.adapter = WineCardSelectAdapter(WineCardSelectAdapter.cardsRes()) {
            noteWriteViewModel.wineNote = noteWriteViewModel.wineNote.copy(
                cardType = it
            )
        }


        lifecycleScope.launchWhenStarted {
            noteWriteViewModel.event.collect {
                when (it) {
                    is NoteWriteEvent.Close -> {
                        println("Close")
                        findNavController().navigateUp()
                    }
                    else -> {
                    }
                }
            }
        }

        initAlcoholContent()
        initImageSelect()
        initTitle()
        initInputNote()
        initWineName()
        initWine()
        initTaste()
        initRating()
        initScent()
        initSave()
    }

    private fun initAlcoholContent() {
        binding.alcoholContentInput.addTextChangedListener {
            noteWriteViewModel.wineNote = noteWriteViewModel.wineNote.copy(
                wine = noteWriteViewModel.wineNote.wine.copy(alcoholContent = it.toString().toFloat())
            )
        }

        buttonValidate()
    }
    private fun initImageSelect() {
        binding.photoInsert.setOnClickListener {

            if (noteWriteViewModel.images.size > 2) {
                requireContext().toast("사진은 최대 3장까지 등록이 가능합니다.")
            } else {
                ImagePicker.with(this)
                    .crop()
                    .compress(1024)
                    .createIntent { intent ->
                        startForProfileImageResult.launch(intent)
                    }
            }
        }

        binding.firstThumbnail.close.setOnClickListener {
            noteWriteViewModel.images.removeAt(0)
            refreshImages()
        }
        binding.secondThumbnail.close.setOnClickListener {
            noteWriteViewModel.images.removeAt(1)
            refreshImages()
        }
        binding.threeThumbnail.close.setOnClickListener {
            noteWriteViewModel.images.removeAt(2)
            refreshImages()
        }

    }

    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            if (resultCode == Activity.RESULT_OK) {
                //Image Uri will not be null for RESULT_OK
                val fileUri = data?.data!!

                noteWriteViewModel.images.add(fileUri)
                noteWriteViewModel.wineNote = noteWriteViewModel.wineNote.copy(
                    thumbnails = noteWriteViewModel.images.map { it.toString() }.toList()
                )
                refreshImages()

            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                requireContext().toast(ImagePicker.getError(data))
            } else {
                requireContext().toast("Task Cancelled")
            }
        }

    private fun refreshImages() {
        when(noteWriteViewModel.images.size) {
            0 -> {
                binding.firstThumbnail.root.isVisible = false
                binding.secondThumbnail.root.isVisible = false
                binding.threeThumbnail.root.isVisible = false
            }
            1 -> {
                binding.firstThumbnail.root.isVisible = true
                binding.secondThumbnail.root.isVisible = false
                binding.threeThumbnail.root.isVisible = false
            }
            2 -> {
                binding.firstThumbnail.root.isVisible = true
                binding.secondThumbnail.root.isVisible = true
                binding.threeThumbnail.root.isVisible = false
            }
            3 -> {
                binding.firstThumbnail.root.isVisible = true
                binding.secondThumbnail.root.isVisible = true
                binding.threeThumbnail.root.isVisible = true
            }
        }

        noteWriteViewModel.images.forEachIndexed { index, uri ->
            when(index) {
                0 -> binding.firstThumbnail.img.setImageURI(uri)
                1 -> binding.secondThumbnail.img.setImageURI(uri)
                2 -> binding.threeThumbnail.img.setImageURI(uri)
            }
        }
    }

    private fun initTitle() {
        binding.input.hint = currentDate()
        binding.input.addTextChangedListener {
            buttonValidate()
        }
    }

    private fun initInputNote() {
        binding.inputNote.addTextChangedListener {
            buttonValidate()
        }
    }

    private fun initWineName() {
        binding.wineNameInput.addTextChangedListener {
            buttonValidate()
        }
    }

    private fun initWine() {
        binding.wineTypeList.adapter = WineSelectAdapter(WineSelect.getWineSelectList()) {
            noteWriteViewModel.wineNote = noteWriteViewModel.wineNote.copy(
                wine = noteWriteViewModel.wineNote.wine.copy(type = it.text)
            )

            buttonValidate()
        }

        binding.wineCountryList.adapter = WineSelectAdapter(WineSelect.getWineCountryList()) {
            noteWriteViewModel.wineNote = noteWriteViewModel.wineNote.copy(
                wine = noteWriteViewModel.wineNote.wine.copy(country = it.text)
            )

            buttonValidate()
        }
    }

    private fun initScent() {
        binding.wineScentListFirst.adapter = WineSelectAdapter(WineSelect.getWineScentList()) {
            noteWriteViewModel.wineNote = noteWriteViewModel.wineNote.copy(
                scentOne = it.text
            )

            buttonValidate()
        }
        binding.wineScentListSecond.adapter = WineSelectAdapter(WineSelect.getWineScentList()) {
            noteWriteViewModel.wineNote = noteWriteViewModel.wineNote.copy(
                scentTwo = it.text
            )
            buttonValidate()
        }
        binding.wineScentListThird.adapter = WineSelectAdapter(WineSelect.getWineScentList()) {
            noteWriteViewModel.wineNote = noteWriteViewModel.wineNote.copy(
                scentThree = it.text
            )
            buttonValidate()
        }
    }

    private fun initSave() = with(binding) {
        save.setOnClickListener {
            if (validateSave(isToast = true)) {
                noteWriteViewModel.saveWineNote()
                //println("WineNote: ${noteWriteViewModel.wineNote}")
            }
        }
    }

    private fun buttonValidate(isToast: Boolean = false) {

        if (validateSave()) {
            binding.save.setTextColor(Color.WHITE)
            binding.save.setBackgroundColor(resources.getColor(R.color.color_333333, null))
        } else {
            binding.save.setTextColor(resources.getColor(R.color.color_333333, null))
            binding.save.setBackgroundColor(resources.getColor(R.color.color_f5f5f5, null))
        }

    }

    private fun validateSave(isToast: Boolean = false): Boolean {
        val context = binding.root.context
        println("title: ${binding.title.text}")
        if (binding.input.text.isEmpty()) {
            if (isToast) context.toast("제목을 입력해 주세요")
            return false
        }

        val title = binding.input.text.toString()
        println("title $title")
        noteWriteViewModel.wineNote = noteWriteViewModel.wineNote.copy(title = title)

        if (binding.inputNote.text.isEmpty()) {
            if (isToast) context.toast("노트 내용을 입력해 주세요")
            return false
        }

        noteWriteViewModel.wineNote =
            noteWriteViewModel.wineNote.copy(note = binding.inputNote.text.toString())

        if (binding.wineName.text.isEmpty()) {
            if (isToast) context.toast("와인 이름을 입력해 주세요")
            return false
        }

        noteWriteViewModel.wineNote =
            noteWriteViewModel.wineNote.copy(wine = noteWriteViewModel.wineNote.wine.copy(name = binding.wineNameInput.text.toString()))

        if (binding.priceInput.text.isEmpty()) {
            if (isToast) context.toast("와인 가격을 입력해 주세요")
            return false
        }

        noteWriteViewModel.wineNote = noteWriteViewModel.wineNote.copy(
            wine = noteWriteViewModel.wineNote.wine.copy(
                price = binding.priceInput.text.toString().toInt()
            )
        )

        if (noteWriteViewModel.wineNote.wine.type.isEmpty()) {
            if (isToast) context.toast("와인 종류를 선택해주세요")
            return false
        }

        //noteWriteViewModel.wineNote = noteWriteViewModel.wineNote.copy(wine = noteWriteViewModel.wineNote.wine.copy(type = binding.wineType.toString()))

        if (noteWriteViewModel.wineNote.wine.country.isEmpty()) {
            if (isToast) context.toast("와인 원산지를 선택해주세요")
            return false
        }

        //noteWriteViewModel.wineNote = noteWriteViewModel.wineNote.copy(wine = noteWriteViewModel.wineNote.wine.copy(country = binding.wineCountry.toString()))

        if (noteWriteViewModel.wineNote.wine.alcoholContent == 0.0f) {
            if (isToast) context.toast("와인 도수를 입력해주세요")
            return false
        }

        if (noteWriteViewModel.wineNote.body == 0) {
            if (isToast) context.toast("강도를 선택해주세요")
            return false
        }

        if (noteWriteViewModel.wineNote.sweet == 0) {
            if (isToast) context.toast("당도를 선택해주세요")
            return false
        }

        if (noteWriteViewModel.wineNote.acid == 0) {
            if (isToast) context.toast("산미를 선택해주세요")
            return false
        }

        if (noteWriteViewModel.wineNote.scentOne.isEmpty()) {
            if (isToast) context.toast("첫번쨰 향을 선택해주세요")
            return false
        }

        if (noteWriteViewModel.wineNote.scentTwo.isEmpty()) {
            if (isToast) context.toast("두번째 향을 선택해주세요")
            return false
        }

        if (noteWriteViewModel.wineNote.scentThree.isEmpty()) {
            if (isToast) context.toast("세번쨰 향을 선택해주세요")
            return false
        }

        if (noteWriteViewModel.wineNote.rating == 0) {
            if (isToast) context.toast("평점을 선택해주세요")
            return false
        }

        return true
    }

    private fun initTaste() = with(binding) {
        tasteSelect.title.text = "강도"
        tasteSelect.startTitle.text = "Light"
        tasteSelect.endTitle.text = "Bold"
        sweetSelect.title.text = "당도"
        sweetSelect.startTitle.text = "Dry"
        sweetSelect.endTitle.text = "Sweet"
        acidSelect.title.text = "산미"
        acidSelect.startTitle.text = "Soft"
        acidSelect.endTitle.text = "Acidic"

        val tasteTextViews = listOf(
            tasteSelect.one,
            tasteSelect.two,
            tasteSelect.three,
            tasteSelect.four,
            tasteSelect.five,
        )

        val sweetTextViews = listOf(
            sweetSelect.one,
            sweetSelect.two,
            sweetSelect.three,
            sweetSelect.four,
            sweetSelect.five,
        )
        val acidTextViews = listOf(
            acidSelect.one,
            acidSelect.two,
            acidSelect.three,
            acidSelect.four,
            acidSelect.five,
        )

        tasteSelect.one.setOnClickListener { tasteTextViews.focusListOfOne(0, "taste") }
        tasteSelect.two.setOnClickListener { tasteTextViews.focusListOfOne(1, "taste") }
        tasteSelect.three.setOnClickListener { tasteTextViews.focusListOfOne(2, "taste") }
        tasteSelect.four.setOnClickListener { tasteTextViews.focusListOfOne(3, "taste") }
        tasteSelect.five.setOnClickListener { tasteTextViews.focusListOfOne(4, "taste") }

        sweetSelect.one.setOnClickListener { sweetTextViews.focusListOfOne(0, "sweet") }
        sweetSelect.two.setOnClickListener { sweetTextViews.focusListOfOne(1, "sweet") }
        sweetSelect.three.setOnClickListener { sweetTextViews.focusListOfOne(2, "sweet") }
        sweetSelect.four.setOnClickListener { sweetTextViews.focusListOfOne(3, "sweet") }
        sweetSelect.five.setOnClickListener { sweetTextViews.focusListOfOne(4, "sweet") }

        acidSelect.one.setOnClickListener { acidTextViews.focusListOfOne(0, "acid") }
        acidSelect.two.setOnClickListener { acidTextViews.focusListOfOne(1, "acid") }
        acidSelect.three.setOnClickListener { acidTextViews.focusListOfOne(2, "acid") }
        acidSelect.four.setOnClickListener { acidTextViews.focusListOfOne(3, "acid") }
        acidSelect.five.setOnClickListener { acidTextViews.focusListOfOne(4, "acid") }
    }

    private fun List<TextView>.focusListOfOne(index: Int, type: String) {
        when (type) {
            "taste" -> noteWriteViewModel.wineNote =
                noteWriteViewModel.wineNote.copy(body = index + 1)
            "sweet" -> noteWriteViewModel.wineNote =
                noteWriteViewModel.wineNote.copy(sweet = index + 1)
            "acid" -> noteWriteViewModel.wineNote =
                noteWriteViewModel.wineNote.copy(acid = index + 1)
        }
        forEachIndexed { i, textView ->
            focusTaste(textView, i == index)
        }
    }

    private fun focusTaste(tv: TextView, isFocus: Boolean) {
        if (isFocus) {
            tv.setTextColor(Color.WHITE)
            tv.setBackgroundColor(resources.getColor(R.color.color_333333, null))
        } else {
            tv.setTextColor(resources.getColor(R.color.color_333333, null))
            tv.setBackgroundColor(resources.getColor(R.color.color_f5f5f5, null))
        }
    }

    private fun initRating() = with(binding) {

        rating1.setOnClickListener {
            noteWriteViewModel.wineNote = noteWriteViewModel.wineNote.copy(rating = 1)
            rating1.setImageResource(R.drawable.ic_favorite_on)
            rating2.setImageResource(R.drawable.ic_favorite_off)
            rating3.setImageResource(R.drawable.ic_favorite_off)
            rating4.setImageResource(R.drawable.ic_favorite_off)
            rating5.setImageResource(R.drawable.ic_favorite_off)
            buttonValidate()
        }
        rating2.setOnClickListener {
            noteWriteViewModel.wineNote = noteWriteViewModel.wineNote.copy(rating = 2)
            rating1.setImageResource(R.drawable.ic_favorite_on)
            rating2.setImageResource(R.drawable.ic_favorite_on)
            rating3.setImageResource(R.drawable.ic_favorite_off)
            rating4.setImageResource(R.drawable.ic_favorite_off)
            rating5.setImageResource(R.drawable.ic_favorite_off)
            buttonValidate()
        }
        rating3.setOnClickListener {
            noteWriteViewModel.wineNote = noteWriteViewModel.wineNote.copy(rating = 3)
            rating1.setImageResource(R.drawable.ic_favorite_on)
            rating2.setImageResource(R.drawable.ic_favorite_on)
            rating3.setImageResource(R.drawable.ic_favorite_on)
            rating4.setImageResource(R.drawable.ic_favorite_off)
            rating5.setImageResource(R.drawable.ic_favorite_off)
            buttonValidate()
        }
        rating4.setOnClickListener {
            noteWriteViewModel.wineNote = noteWriteViewModel.wineNote.copy(rating = 4)
            rating1.setImageResource(R.drawable.ic_favorite_on)
            rating2.setImageResource(R.drawable.ic_favorite_on)
            rating3.setImageResource(R.drawable.ic_favorite_on)
            rating4.setImageResource(R.drawable.ic_favorite_on)
            rating5.setImageResource(R.drawable.ic_favorite_off)
            buttonValidate()
        }
        rating5.setOnClickListener {
            noteWriteViewModel.wineNote = noteWriteViewModel.wineNote.copy(rating = 5)
            rating1.setImageResource(R.drawable.ic_favorite_on)
            rating2.setImageResource(R.drawable.ic_favorite_on)
            rating3.setImageResource(R.drawable.ic_favorite_on)
            rating4.setImageResource(R.drawable.ic_favorite_on)
            rating5.setImageResource(R.drawable.ic_favorite_on)
            buttonValidate()
        }
    }
}