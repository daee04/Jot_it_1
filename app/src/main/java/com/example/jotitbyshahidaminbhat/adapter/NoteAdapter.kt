package com.example.jotitbyshahidaminbhat.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jotitbyshahidaminbhat.databinding.NoteItemLayoutBinding
import com.example.jotitbyshahidaminbhat.fragments.HomeFragmentDirections
import com.example.jotitbyshahidaminbhat.model.Note
import java.util.Random
@Suppress("UNREACHABLE_CODE")
class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {


    class NoteViewHolder(val itemBinding : NoteItemLayoutBinding) : RecyclerView.ViewHolder(itemBinding.root)
    private val differCallback = object : DiffUtil.ItemCallback<Note>(){

        @SuppressLint("NotifyDataSetChanged")
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id && oldItem.noteTitle == newItem.noteTitle && oldItem.noteBody==newItem.noteBody
            notifyDataSetChanged()
        }

        @SuppressLint("NotifyDataSetChanged")
        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
          return oldItem==newItem
            notifyDataSetChanged()
        }
    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
       return  NoteViewHolder(NoteItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
          val currentNote = differ.currentList[position]

        holder.itemBinding.tvNoteTitle.text = currentNote.noteTitle
        holder.itemBinding.tvNoteBody.text = currentNote.noteBody

        val random = Random()
        val color = Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256))

        holder.itemBinding.ibColor.setBackgroundColor(color)
        holder.itemView.setOnClickListener{
            val direction = HomeFragmentDirections.actionHomeFragmentToUpdateNoteFragment(currentNote)
            it.findNavController().navigate(direction)
        }

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}