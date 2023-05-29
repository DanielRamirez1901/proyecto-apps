package com.example.interfaces_pr.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.interfaces_pr.CourseActivity
import com.example.interfaces_pr.databinding.DeportesCursosBinding
import com.example.interfaces_pr.databinding.DesarrolloCursosBinding

class cursosDesarrolloFragment  : Fragment() {

    private lateinit var binding: DesarrolloCursosBinding // declara la variable binding
    private val courseType:String = "Desarrollo H"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DesarrolloCursosBinding.inflate(inflater, container, false) // inicializa la variable binding

        binding.desarrolloImg.setOnClickListener{
            val courseName = "Desarrollo Personal"
            goToCourse(courseName,courseType)
        }
        binding.acompaAmientoImg.setOnClickListener{
            val courseName = "Acompañamiento"
            goToCourse(courseName,courseType)
        }
        binding.induccionImg.setOnClickListener{
            val courseName = "Induccion"
            goToCourse(courseName,courseType)
        }
        return binding.root // retorna la vista inflada a través de la variable binding
    }

    private fun goToCourse(courseName:String,courseType:String){
        val intent = Intent(this.activity,CourseActivity::class.java).apply {
            putExtra("course name",courseName)
            putExtra("course type",courseType)
        }
        startActivity(intent)
    }
}
