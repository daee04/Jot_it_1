package com.example.jotitbyshahidaminbhat.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.jotitbyshahidaminbhat.MainActivity
import com.example.jotitbyshahidaminbhat.R
import com.example.jotitbyshahidaminbhat.adapter.NoteAdapter
import com.example.jotitbyshahidaminbhat.databinding.FragmentHomeBinding
import com.example.jotitbyshahidaminbhat.model.Note
import com.example.jotitbyshahidaminbhat.viewmodel.NoteViewModel


class HomeFragment : Fragment(R.layout.fragment_home), SearchView.OnQueryTextListener {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var noteViewModel: NoteViewModel
    private lateinit var noteAdapter: NoteAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
      _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        noteViewModel = (activity as MainActivity).noteViewModel
        setUpRecyclerView()

        binding.fabAddButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_homeFragment_to_newNoteFragment)
        }

    }

    private fun setUpRecyclerView() {
        noteAdapter = NoteAdapter()
        binding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = noteAdapter


        }


        activity.let {
            noteViewModel.getAllNotes().observe(
                viewLifecycleOwner
            ) { note ->
                noteAdapter.differ.submitList(note)
                updateUi(note)
            }
        }

    }

    private fun updateUi(note: List<Note>?) {
        if(note==null){
            binding.cardView2.visibility = View.VISIBLE
            binding.recyclerView.visibility = View.GONE

        }else
        {

            binding.cardView2.visibility= View.GONE
            binding.recyclerView.visibility= View.VISIBLE
        }

    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.home_menu,menu)
        val mMenuSearch = menu.findItem(R.id.search).actionView as SearchView

        mMenuSearch.isSubmitButtonEnabled = false

        mMenuSearch.setOnQueryTextListener(this)


    }


    @SuppressLint("SuspiciousIndentation")
    private fun searchNote(query: String?) {
     val searchQuery = "% $query"
        noteViewModel.searchNote(searchQuery).observe(
            this
        ) { list -> noteAdapter.differ.submitList(list) }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        searchNote(p0)
        return false
    }

    override fun onQueryTextChange(p0: String?): Boolean {
       if(p0 != null)
       {
           searchNote(p0)
       }
        return true
    }


}


