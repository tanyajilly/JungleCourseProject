package com.jungle.android.course

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jungle.android.course.adapter.ToDoListAdapter
import com.jungle.android.course.model.NoteModel

class NoteActivity : AppCompatActivity() {

    private lateinit var tvTitle: TextView
    private lateinit var tvDescription: TextView
    private lateinit var rvToDo: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        tvTitle = findViewById(R.id.tvTitle)
        tvDescription = findViewById(R.id.tvDescription)
        rvToDo = findViewById(R.id.rvToDo)

        val note = intent.getParcelableExtra<NoteModel>(NOTE_EXTRA)

        tvTitle.text = note?.title ?: ""

        note?.description?.let {
            tvDescription.visibility = View.VISIBLE
            tvDescription.text = it
        }

        note?.toDoList?.let {
            rvToDo.layoutManager = LinearLayoutManager(this)
            rvToDo.adapter = ToDoListAdapter(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.note_activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        when (itemId) {
            R.id.edit -> {
                Toast.makeText(this, "Edit note", Toast.LENGTH_SHORT).show()
            }
            R.id.delete -> {
                Toast.makeText(this, "Delete note", Toast.LENGTH_SHORT).show()
            }
            R.id.share -> {
                Toast.makeText(this, "Share note", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}