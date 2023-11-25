package com.example.jotitbyshahidaminbhat.room

import androidx.lifecycle.LiveData
import com.example.jotitbyshahidaminbhat.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(private val db: NoteDatabase) {

    suspend fun insertNote(note: Note) {
        withContext(Dispatchers.IO) {
            db.setNoteDao().insertNote(note)
        }
    }

    suspend fun deleteNote(note: Note) {
        withContext(Dispatchers.IO) {
            db.setNoteDao().deleteNote(note)
        }
    }

    suspend fun updateNote(note: Note) {
        withContext(Dispatchers.IO) {
            db.setNoteDao().updateNote(note)
        }
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return db.setNoteDao().getAllNotes()
    }

    fun searchNotes(query: String?): LiveData<List<Note>> {
        return db.setNoteDao().searchNotes(query)
    }
}
