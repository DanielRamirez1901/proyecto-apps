package com.example.campusbu.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.campusbu.databinding.CulturaCursosBinding
import com.example.campusbu.databinding.DeportesCursosBinding

class cursosCulturaFragment  : Fragment() {
    private lateinit var binding: CulturaCursosBinding // declara la variable binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = CulturaCursosBinding.inflate(inflater, container, false) // inicializa la variable binding
        return binding.root // retorna la vista inflada a través de la variable binding
    }

}
