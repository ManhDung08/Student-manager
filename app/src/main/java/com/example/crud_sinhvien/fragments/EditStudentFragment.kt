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

class EditStudentFragment : Fragment() {

    private lateinit var editTextName: EditText
    private lateinit var editTextId: EditText
    private lateinit var buttonSave: Button
    private lateinit var student: StudentModel

    companion object {
        fun newInstance(student: StudentModel): EditStudentFragment {
            val fragment = EditStudentFragment()
            val bundle = Bundle()
            bundle.putString("studentName", student.studentName)
            bundle.putString("studentId", student.studentId)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        student = StudentModel(
            arguments?.getString("studentName") ?: "",
            arguments?.getString("studentId") ?: ""
        )

        editTextName = view.findViewById(R.id.editTextStudentName)
        editTextId = view.findViewById(R.id.editTextStudentId)
        buttonSave = view.findViewById(R.id.buttonUpdateStudent)

        editTextName.setText(student.studentName)
        editTextId.setText(student.studentId)

        buttonSave.setOnClickListener {
            student.studentName = editTextName.text.toString()
            student.studentId = editTextId.text.toString()

            (activity as MainActivity).openFragment(StudentListFragment())
        }
    }
}
