package com.example.interfaces_pr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.interfaces_pr.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:LoginFragmentBinding = LoginFragmentBinding.inflate(inflater,container,false)


        return binding.root
    }

    companion object{
        fun newInstance():LoginFragment{
            return LoginFragment()
        }
    }
}