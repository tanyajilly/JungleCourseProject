package com.jungle.android.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ShareFragment: Fragment() {
    private lateinit var tvPageText: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvPageText = requireActivity().findViewById(R.id.tvPageText)
        tvPageText.text = "Share page here"
    }

    companion object {
        fun newInstance(): ShareFragment{
            return ShareFragment()
        }
    }
}