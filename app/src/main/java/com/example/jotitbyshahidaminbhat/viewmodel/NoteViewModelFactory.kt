package com.example.jotitbyshahidaminbhat.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jotitbyshahidaminbhat.room.Repository

@Suppress("UNCHECKED_CAST")
class NoteViewModelFactory(val app : Application, private val noteRepository : Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(app,noteRepository) as  T
    }
}