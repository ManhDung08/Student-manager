package com.example.crud_sinhvien.fragments

import StudentAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.crud_sinhvien.MainActivity
import com.example.crud_sinhvien.R

class StudentListFragment : Fragment() {

    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView = view.findViewById(R.id.listViewStudents)
        val adapter = StudentAdapter(requireContext(), (activity as MainActivity).students)
        listView.adapter = adapter
    }
}
