package com.jungle.android.course

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.jungle.android.course.adapter.NotesAdapter
import com.jungle.android.course.model.NoteModel
import com.jungle.android.course.model.ToDoModel

class ListActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var navigationHeaderText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        drawer = findViewById(R.id.drawer)
        navigationView = findViewById(R.id.navView)

        setSupportActionBar(findViewById(R.id.toolbar))
        val drawerToggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigationView.setNavigationItemSelectedListener(this)

        val colors = listOf(R.color.light_gray, R.color.light_blue, R.color.purple, R.color.yellow)

        val notes = arrayListOf(
            NoteModel(
                title = "Shopping",
                description = "Buy food for dinner",
                backgroundColorResId = colors.random(),
                toDoList = listOf(
                    ToDoModel(
                        title = "Milk",
                        isDone = true,
                    ),
                    ToDoModel(
                        title = "Cheese",
                        isDone = false,
                    ),
                    ToDoModel(
                        title = "Meat",
                        isDone = true,
                    )
                )
            ),
            NoteModel(
                title = "Films for evening",
                backgroundColorResId = colors.random(),
                toDoList = listOf(
                    ToDoModel(
                        title = "Pulp fiction"
                    ),
                    ToDoModel(
                        title = "Batman",
                        isDone = true
                    ),
                    ToDoModel(
                        title = "Godfather",
                        isDone = false
                    ),
                )
            ),
            NoteModel(
                title = "Books from Mike",
                description = "Book1, Book2, Book3",
                backgroundColorResId = colors.random()

            ),
            NoteModel(
                title = "My top 3 laptops",
                description = "Lenovo, HP, Macbook",
                backgroundColorResId = colors.random()

            ),
            NoteModel(
                title = "Note1",
                description = "Milk, Cheese, Meat",
                backgroundColorResId = colors.random()

            ),
            NoteModel(
                title = "Films for evening",
                description = "Film1, Film2, Film3",
                backgroundColorResId = colors.random()

            ),
            NoteModel(
                title = "Books from Mike",
                description = "Book1, Book2, Book3",
                backgroundColorResId = colors.random()

            ),
            NoteModel(
                title = "My top 3 laptops",
                description = "Lenovo, HP, Macbook",
                backgroundColorResId = colors.random()

            ),
            NoteModel(
                title = "Note1",
                description = "Milk, Cheese, Meat",
                backgroundColorResId = colors.random()

            ),
            NoteModel(
                title = "Films for evening",
                description = "Film1, Film2, Film3",

            ),
            NoteModel(
                title = "Books from Mike",
            ),
            NoteModel(
                title = "My top 3 laptops",
                description = "Lenovo, HP, Macbook",
            )
        )

        val fragment = NoteListFragment.newInstance(notes)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.flContainer, fragment)
            .commit()

        navigationHeaderText = navigationView.getHeaderView(0).findViewById(R.id.tvNotesHeading)
        navigationHeaderText?.text = getString(R.string.notes_counter, notes.size)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                drawer.openDrawer(GravityCompat.START)
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.notes -> {
                Toast.makeText(this, "Notes", Toast.LENGTH_SHORT).show()
            }
            R.id.settings -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flContainer, SettingsFragment.newInstance())
                    .commit()
            }
            R.id.logout -> {
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_share -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flContainer, ShareFragment.newInstance())
                    .commit()
            }
            R.id.nav_send -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flContainer, SupportFragment.newInstance())
                    .commit()
            }
        }
        drawer.closeDrawer(GravityCompat.START)

        return true
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}