package com.example.interfaces_pr

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.interfaces_pr.databinding.ActivityMain2Binding
import com.example.interfaces_pr.fragments.LoginFragment
import com.example.interfaces_pr.fragments.RegisterFragment

class LoginActivity : AppCompatActivity() {

    private val binding:ActivityMain2Binding by lazy{
        ActivityMain2Binding.inflate(layoutInflater)
    }

    private val login = LoginFragment.newInstance()
    private val register = RegisterFragment.newInstance()
    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        showFragment(login)

        binding.iniciarSesiontxt.setOnClickListener{
            binding.registrarsetxt.setTextColor(Color.rgb(129,129,129))
            binding.iniciarSesiontxt.setTextColor(Color.rgb(0,0,0))
            showFragment(login)
        }

        binding.registrarsetxt.setOnClickListener{
            binding.iniciarSesiontxt.setTextColor(Color.rgb(129,129,129))
            binding.registrarsetxt.setTextColor(Color.rgb(0,0,0))
            showFragment(register)
        }

        /*
        val loginFragment = supportFragmentManager.findFragmentById(R.id.loginContainerFL) as? LoginFragment
        val codeLogin = loginFragment?.getBinding()?.codeLoginET?.text.toString()
        val passwordLogin = loginFragment?.getBinding()?.passwordLoginET?.text.toString()
        Log.d("TAG", "Valor de EditText1: $codeLogin")
        Log.d("TAG", "Valor de EditText2: $passwordLogin")
         */
        binding.loginBtn.setOnClickListener{
            goToMainActivity()
        }
    }



    private fun showFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.nada,fragment).commit()
    }

    private fun goToMainActivity() {

        val intent = Intent(this, MainActivity1::class.java)
        startActivity(intent)

    }

}