package com.margin.wine.write

sealed class NoteWriteEvent {

    object Init : NoteWriteEvent()

    object Close : NoteWriteEvent()

}