package com.example.crud_sinhvien.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.crud_sinhvien.MainActivity
import com.example.crud_sinhvien.R
import com.example.crud_sinhvien.StudentModel

class AddStudentFragment : Fragment() {

    private lateinit var editTextName: EditText
    private lateinit var editTextId: EditText
    private lateinit var buttonAdd: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextName = view.findViewById(R.id.editTextStudentName)
        editTextId = view.findViewById(R.id.editTextStudentId)
        buttonAdd = view.findViewById(R.id.buttonAddStudent)

        buttonAdd.setOnClickListener {
            val studentName = editTextName.text.toString()
            val studentId = editTextId.text.toString()

            if (studentName.isNotEmpty() && studentId.isNotEmpty()) {
                val newStudent = StudentModel(studentName, studentId)
                (activity as MainActivity).students.add(newStudent)
                (activity as MainActivity).openFragment(StudentListFragment())
            }
        }
    }
}
