package com.jungle.android.course.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ToDoModel(
    val title: String,
    val isDone: Boolean = false
) : Parcelable
