package com.example.interfaces_pr

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.interfaces_pr.databinding.ActivityMain2Binding
import com.example.interfaces_pr.fragments.LoginFragment
import com.example.interfaces_pr.fragments.RegisterFragment
import com.example.interfaces_pr.model.User
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson


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

        binding.loginBtn.setOnClickListener {view ->

            val currentFragment = supportFragmentManager.findFragmentById(R.id.nada)

            if (currentFragment is LoginFragment) {

                val email = login.binding.codeLoginET.editText?.text.toString()
                val pass = login.binding.passwordLoginET.editText?.text.toString()

                if (email.isBlank() || pass.isBlank()){
                    Toast.makeText(this, "Rellena los campos vacios", Toast.LENGTH_LONG).show()
                }else{
                    Firebase.auth.signInWithEmailAndPassword(email, pass).addOnSuccessListener {
                        val fbuser = Firebase.auth.currentUser
                        if (fbuser!!.isEmailVerified){
                            //se le permite el acceso
                            Firebase.firestore.collection("users").document(fbuser.uid).get().addOnSuccessListener {
                                val user = it.toObject(User::class.java)
                                //guardar usuario en la cache
                                saveUser(user!!)
                                goToMainActivity()
                                finish()
                            }
                        }else{
                            Toast.makeText(this, "su email aun no ha sido verificado", Toast.LENGTH_LONG).show()
                        }
                    }.addOnFailureListener{
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                }

            } else if (currentFragment is RegisterFragment) {
                registrarUsuario(view)
            }

        }

    }

    private fun showFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.nada,fragment).commit()
    }
    fun registrarUsuario(view: View) {
        //Parte 1___
        // Obtiene el correo electrónico y la contraseña de la actividad RegisterFragment
        val email = register.binding.emailET.editText?.text.toString()
        val password = register.binding.passET.editText?.text.toString()
        val codeUsuario = register.binding.codeUsuarioET.editText?.text.toString()
        val username = register.binding.usernameET.editText?.text.toString()

        if (email.isBlank() || password.isBlank() || codeUsuario.isBlank() || username.isBlank()){
            Toast.makeText(this, "Rellena los campos vacios", Toast.LENGTH_LONG).show()
        }else{
            // Autentica al usuario con Firebase Auth
            Firebase.auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener{
                    //Parte 2____
                    val id = Firebase.auth.currentUser?.uid
                    val user = User(id!!, codeUsuario, email, username)

                    Firebase.firestore.collection("users").document(id).set(user).addOnCompleteListener {
                        sendVerifyEmail()
                    }
                }.addOnFailureListener{
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
        }


    }
    fun sendVerifyEmail(){
        Firebase.auth.currentUser?.sendEmailVerification()?.addOnSuccessListener {
            Toast.makeText(this, "Listo! Verifica el correo que te mandamos", Toast.LENGTH_LONG).show()
        }?.addOnFailureListener{
            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()

        }
    }
    fun saveUser(user: User){
        val sp = getSharedPreferences("CampusBu", MODE_PRIVATE)
        val json = Gson().toJson(user)
        sp.edit().putString("user", json).apply()
    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity1::class.java)
        startActivity(intent)
    }
}