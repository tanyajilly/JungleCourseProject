package com.jungle.android.course.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.jungle.android.course.R
import com.jungle.android.course.model.ToDoModel

class ToDoListAdapter(
    private val toDoModelList: List<ToDoModel>
) : RecyclerView.Adapter<ToDoListAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val toDoCheckBox: CheckBox = view.findViewById(R.id.todoCheckBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        return ToDoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.to_do_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val toDoItem = toDoModelList[position]

        holder.toDoCheckBox.isChecked = toDoItem.isDone
        holder.toDoCheckBox.text = toDoItem.title
    }

    override fun getItemCount(): Int {
        return toDoModelList.size
    }
}