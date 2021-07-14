package com.jungle.android.course

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jungle.android.course.adapter.ToDoListAdapter
import com.jungle.android.course.model.NoteModel

class NoteFragment: Fragment() {

    private lateinit var tvTitle: TextView
    private lateinit var tvDescription: TextView
    private lateinit var rvToDo: RecyclerView
    private var note: NoteModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        note = arguments?.getParcelable<NoteModel>(NOTE_EXTRA)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tvTitle = requireActivity().findViewById(R.id.tvTitle)
        tvDescription = requireActivity().findViewById(R.id.tvDescription)
        rvToDo = requireActivity().findViewById(R.id.rvToDo)

        tvTitle.text = note?.title ?: ""

        note?.description?.let {
            tvDescription.visibility = View.VISIBLE
            tvDescription.text = it
        }

        note?.toDoList?.let {
            rvToDo.layoutManager = LinearLayoutManager(requireContext())
            rvToDo.adapter = ToDoListAdapter(it)
        }
    }

    companion object {
        fun newInstance(noteModel: NoteModel): NoteFragment{
            val fragment = NoteFragment()

            val bundle = Bundle()
            bundle.putParcelable(NOTE_EXTRA, noteModel)

            fragment.arguments = bundle
            return fragment
        }
    }
}