package com.jungle.android.course.model

import android.os.Parcelable
import com.jungle.android.course.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class NoteModel(
    val title: String,
    val description: String? = null,
    val backgroundColorResId: Int = R.color.light_gray,
    val toDoList: List<ToDoModel>? = null
) : Parcelable
