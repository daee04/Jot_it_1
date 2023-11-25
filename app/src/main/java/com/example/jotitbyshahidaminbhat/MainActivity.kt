package com.example.jotitbyshahidaminbhat


import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.jotitbyshahidaminbhat.databinding.ActivityMainBinding
import com.example.jotitbyshahidaminbhat.room.NoteDatabase
import com.example.jotitbyshahidaminbhat.room.Repository
import com.example.jotitbyshahidaminbhat.viewmodel.NoteViewModel
import com.example.jotitbyshahidaminbhat.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    public lateinit var noteViewModel: NoteViewModel
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setUpViewModel()
    }



    private fun setUpViewModel() {
      val noteRepository = Repository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(Application(),noteRepository)
        noteViewModel = ViewModelProvider(
            this,
            viewModelProviderFactory)[NoteViewModel::class.java]

    }
}