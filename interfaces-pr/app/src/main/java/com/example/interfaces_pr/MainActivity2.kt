package com.example.interfaces_pr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.interfaces_pr.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private val binding:ActivityMain2Binding by lazy{
        ActivityMain2Binding.inflate(layoutInflater)
    }

    private val login = LoginFragment.newInstance()
    private val register = RegisterFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        showFragment(login)

        binding.iniciarSesiontxt.setOnClickListener{
            showFragment(login)
        }

        binding.registrarsetxt.setOnClickListener{
            showFragment(register)
        }

    }



    fun showFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.nada,fragment).commit()
    }
}