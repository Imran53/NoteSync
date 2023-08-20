package com.swe.notesync.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swe.notesync.model.Note
import com.swe.notesync.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteActivityViewModel(private val repository: NoteRepository) : ViewModel() {

    fun saveNote(newNote : Note) =viewModelScope.launch (Dispatchers.IO ){
        repository.addNote(newNote)
    }

    fun updateNote(existingNote : Note) =viewModelScope.launch(Dispatchers.IO ){
        repository.updateNote(existingNote)
    }

    fun deleteNote(existingNote: Note) =viewModelScope.launch(Dispatchers.IO ){
        repository.deleteNote(existingNote)
    }

    fun searchNote(query: String): LiveData<List<Note>>
    {
        return repository.searchNote(query)
    }

    fun getAllNotes(): LiveData<List<Note>> = repository.getNote()

}