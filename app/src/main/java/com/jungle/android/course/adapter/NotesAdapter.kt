package com.jungle.android.course.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jungle.android.course.NOTE_EXTRA
import com.jungle.android.course.NoteActivity
import com.jungle.android.course.R
import com.jungle.android.course.model.NoteModel

class NotesAdapter(
    private val notesList: List<NoteModel>
) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    inner class NotesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvDescription: TextView = view.findViewById(R.id.tvDescription)
        val cvMainContainer: CardView = view.findViewById(R.id.cvMainContainer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note = notesList[position]

        holder.tvTitle.text = note.title
        holder.tvDescription.text = note.description

        val context = holder.itemView.context
        holder.cvMainContainer.setCardBackgroundColor(
            ContextCompat.getColor(
                context,
                note.backgroundColorResId
            )
        )

        //Context это объект который предоставляет доступ к ресурсам, файловой системе, запуску активити в приложении.

        holder.itemView.setOnClickListener {
            val intent = Intent(context, NoteActivity::class.java)
            intent.putExtra(NOTE_EXTRA, note)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return notesList.size
    }
}