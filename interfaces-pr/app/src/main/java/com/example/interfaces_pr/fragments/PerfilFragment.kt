package com.example.interfaces_pr.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.interfaces_pr.R
import com.example.interfaces_pr.databinding.PerfilfragmentBinding

class PerfilFragment(private val username: String) : Fragment() {

    private lateinit var binding: PerfilfragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = PerfilfragmentBinding.inflate(inflater, container, false)

        binding.name.text = username

        return binding.root
    }
}
