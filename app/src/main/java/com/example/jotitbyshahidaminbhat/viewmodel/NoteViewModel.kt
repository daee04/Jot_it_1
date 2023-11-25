package com.example.jotitbyshahidaminbhat.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.jotitbyshahidaminbhat.model.Note
import com.example.jotitbyshahidaminbhat.room.Repository
import kotlinx.coroutines.launch

class NoteViewModel(app: Application,private val noteRepository : Repository) : AndroidViewModel(app) {

    fun addNote(note: Note) = viewModelScope.launch {
        noteRepository.insertNote(note)
    }

    fun deleteNote(note: Note) = viewModelScope.launch {
        noteRepository.deleteNote(note)
    }

    fun updateNote(note: Note) = viewModelScope.launch {
        noteRepository.updateNote(note)
    }

    fun getAllNotes() = noteRepository.getAllNotes()
    fun searchNote(query : String?) = noteRepository.searchNotes(query)
}