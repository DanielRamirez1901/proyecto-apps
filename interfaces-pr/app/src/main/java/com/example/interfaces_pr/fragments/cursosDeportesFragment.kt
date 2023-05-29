package com.example.interfaces_pr.fragments


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.interfaces_pr.CourseActivity
import com.example.interfaces_pr.databinding.DeportesCursosBinding

class cursosDeportesFragment  : Fragment() {

    private lateinit var binding: DeportesCursosBinding // declara la variable binding
    private val courseType:String = "Deportes"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DeportesCursosBinding.inflate(inflater, container, false) // inicializa la variable binding

        binding.futbolImg.setOnClickListener{
            val courseName = "Futbol"
            goToCourse(courseName,courseType)
        }
        binding.tennisImg.setOnClickListener{
            val courseName = "Tennis"
            goToCourse(courseName,courseType)
        }
        binding.tiroArcoImg.setOnClickListener{
            val courseName = "Tiro con Arco"
            goToCourse(courseName,courseType)
        }
        binding.desarrolloImg.setOnClickListener{
            val courseName = "Basketball"
            goToCourse(courseName,courseType)
        }
        return binding.root // retorna la vista inflada a través de la variable binding
    }

    private fun goToCourse(courseName:String,courseType:String){
        val intent = Intent(this.activity, CourseActivity::class.java).apply {
            putExtra("course name",courseName)
            putExtra("course type",courseType)
        }
        startActivity(intent)
    }
}
