package com.example.interfaces_pr.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.interfaces_pr.CourseActivity
import com.example.interfaces_pr.databinding.CulturaCursosBinding
import com.example.interfaces_pr.databinding.DeportesCursosBinding

class cursosCulturaFragment  : Fragment() {
    private lateinit var binding: CulturaCursosBinding // declara la variable binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = CulturaCursosBinding.inflate(inflater, container, false) // inicializa la variable binding


        binding.artesEscenicasImg.setOnClickListener{
            println("wenas")
            goToCourse()
        }
        binding.artesVisualesImg.setOnClickListener{
            println("wenas")
            goToCourse()
        }
        binding.desarrolloImg.setOnClickListener{
            println("wenas")
            goToCourse()
        }
        return binding.root // retorna la vista inflada a través de la variable binding

    }
    private fun goToCourse(){
        val intent = Intent(this.activity,CourseActivity::class.java)
        startActivity(intent)
    }
}
