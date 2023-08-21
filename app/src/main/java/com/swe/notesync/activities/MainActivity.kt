package com.swe.notesync.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.swe.notesync.R
import com.swe.notesync.databinding.ActivityMainBinding
import com.swe.notesync.db.NoteDatabase
import com.swe.notesync.repository.NoteRepository
import com.swe.notesync.viewModel.NoteActivityViewModel
import com.swe.notesync.viewModel.NoteActivityViewModelFactory
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    lateinit var noteActivityViewModel: NoteActivityViewModel
    private lateinit var binding:ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding=ActivityMainBinding.inflate(layoutInflater)

        try{
            setContentView(binding.root)
            val noteRepository=NoteRepository(NoteDatabase(this))
            val noteActivityViewModelFactory= NoteActivityViewModelFactory(noteRepository)
            noteActivityViewModel=ViewModelProvider(this,
            noteActivityViewModelFactory)[NoteActivityViewModel::class.java]
        }catch (e:Exception)
        {
            Log.d("TAG","Error")
        }

    }
}