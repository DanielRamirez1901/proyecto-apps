package com.example.campusbu.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.campusbu.databinding.DesarrolloCursosBinding
import com.example.campusbu.databinding.MisPublicacionesBinding
import com.example.campusbu.databinding.PublicacionesGeneralesBinding

class mis_publicacionesFragment   : Fragment() {
    private lateinit var binding: MisPublicacionesBinding // declara la variable binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = MisPublicacionesBinding.inflate(inflater, container, false) // inicializa la variable binding
        return binding.root // retorna la vista inflada a través de la variable binding
    }
}