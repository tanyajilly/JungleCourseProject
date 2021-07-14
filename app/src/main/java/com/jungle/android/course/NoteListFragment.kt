package com.jungle.android.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jungle.android.course.adapter.NotesAdapter
import com.jungle.android.course.model.NoteModel

class NoteListFragment: Fragment() {

    private lateinit var rvNotes: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_note_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rvNotes = requireActivity().findViewById(R.id.rvNotes)

        val notes = arguments?.getParcelableArrayList<NoteModel>(NOTE_LIST_EXTRA)

        if(notes != null){
            rvNotes.layoutManager = GridLayoutManager(requireContext(), 2)
            rvNotes.adapter = NotesAdapter(notes, requireActivity())
        }
    }

    companion object{
        fun newInstance(notesList: ArrayList<NoteModel>): NoteListFragment{
            val bundle = Bundle()
            bundle.putParcelableArrayList(NOTE_LIST_EXTRA, notesList)

            val fragment = NoteListFragment()
            fragment.arguments = bundle

            return fragment
        }
    }
}