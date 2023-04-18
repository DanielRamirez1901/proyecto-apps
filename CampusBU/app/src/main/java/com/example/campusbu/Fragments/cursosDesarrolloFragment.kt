package com.example.campusbu.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.campusbu.databinding.DeportesCursosBinding
import com.example.campusbu.databinding.DesarrolloCursosBinding

class cursosDesarrolloFragment  : Fragment() {
    private lateinit var binding: DesarrolloCursosBinding // declara la variable binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DesarrolloCursosBinding.inflate(inflater, container, false) // inicializa la variable binding
        return binding.root // retorna la vista inflada a través de la variable binding
    }

}
