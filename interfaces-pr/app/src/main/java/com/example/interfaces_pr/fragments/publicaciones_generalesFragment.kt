package com.example.interfaces_pr.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.interfaces_pr.databinding.DesarrolloCursosBinding
import com.example.interfaces_pr.databinding.PublicacionesGeneralesBinding

class publicaciones_generalesFragment   : Fragment() {
    private lateinit var binding: PublicacionesGeneralesBinding // declara la variable binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = PublicacionesGeneralesBinding.inflate(inflater, container, false) // inicializa la variable binding
        return binding.root // retorna la vista inflada a través de la variable binding
    }
}