package com.example.interfaces_pr.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.interfaces_pr.databinding.RegisterFragmentBinding

class RegisterFragment : Fragment() {

    lateinit var binding : RegisterFragmentBinding
    override fun onCreateView(
        inflater:LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RegisterFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }


    companion object {
        fun newInstance(): RegisterFragment {
            return RegisterFragment()
        }
    }
    fun getBindingRegister(): RegisterFragmentBinding {
        return binding
    }
}
