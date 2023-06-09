package com.example.interfaces_pr


import android.content.Context
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.interfaces_pr.adapter.NotificationAdapter
import com.example.interfaces_pr.fragments.*
import com.example.interfaces_pr.R.id
import com.example.interfaces_pr.databinding.ActivityMainBinding
import com.example.interfaces_pr.databinding.PerfilfragmentBinding
import com.example.interfaces_pr.model.User
import com.google.gson.Gson

class MainActivity1 : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private lateinit var button_home: ImageButton
    private lateinit var button_publi: ImageButton
    private lateinit var button_noti: ImageButton
    private lateinit var button_perfil: ImageButton
    private lateinit var button_Cultura: Button
    private lateinit var button_Deportes: Button
    private lateinit var button_Desarrollo: Button
    private lateinit var notiAdapter:NotificationAdapter
    private var username:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val homeFragment = inflater.inflate(R.layout.homefragment, null)
        username = intent.extras?.getString("username")

        button_home = findViewById(id.button_home)
        button_publi = findViewById(id.button_publi)
        button_noti = findViewById(id.button_noti)
        button_perfil = findViewById(id.button_perfil)

        button_Cultura = homeFragment.findViewById(id.button_Cultura)
        button_Deportes = homeFragment.findViewById(id.button_deportes)
        button_Desarrollo = homeFragment.findViewById(id.button_desarrollo)

        button_home.setColorFilter(ContextCompat.getColor(this,R.color.azulito), PorterDuff.Mode.SRC_IN)
        button_Cultura.setBackgroundResource(R.drawable.borde_navegation_of_home)

        supportFragmentManager.beginTransaction()
            .replace(id.fragment_container, HomeFragment())
            .commit()
        replaceFragmentHome(cursosCulturaFragment())

        if(username!=null || username==""){
            replaceFragment(PerfilFragment(username!!))
            button_home.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            button_publi.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            button_noti.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            button_perfil.setColorFilter(ContextCompat.getColor(this,R.color.azulito), PorterDuff.Mode.SRC_IN)
            username=""
        }
        //para cambiar el color a la barra de navegación
        button_noti.setOnClickListener {
            replaceFragment(NotiFragment())
            button_home.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            button_publi.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            button_noti.setColorFilter(ContextCompat.getColor(this,R.color.azulito), PorterDuff.Mode.SRC_IN)
            button_perfil.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)

        }
        button_home.setOnClickListener {
            replaceFragment(HomeFragment())
            button_home.setColorFilter(ContextCompat.getColor(this,R.color.azulito), PorterDuff.Mode.SRC_IN)
            button_noti.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            button_perfil.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            button_publi.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            replaceFragmentHome(cursosCulturaFragment())
        }
        button_publi.setOnClickListener {
            replaceFragment(PubliFragment())
            button_home.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            button_publi.setColorFilter(ContextCompat.getColor(this,R.color.azulito), PorterDuff.Mode.SRC_IN)
            button_noti.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            button_perfil.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            replaceFragmentHome(publicaciones_generalesFragment())
        }
        button_perfil.setOnClickListener {
            var usernamePrincipal = getUser()?.username
            replaceFragment(PerfilFragment(usernamePrincipal!!))
            button_home.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            button_publi.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            button_noti.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            button_perfil.setColorFilter(ContextCompat.getColor(this,R.color.azulito), PorterDuff.Mode.SRC_IN)

        }

    }
    // Reemplazar el fragmento actual con uno nuevo
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(id.fragment_container, fragment)
            .commit()
    }
    private fun replaceFragmentHome(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(id.fragment_container_home, fragment)
            .commit()
    }
    fun onClickButtonCultura(view: View) {
        // Código que se ejecuta cuando el botón es presionado
        replaceFragmentHome(cursosCulturaFragment())
    }
    fun onClickButtonDeportes(view: View) {
        // Código que se ejecuta cuando el botón es presionado
        replaceFragmentHome(cursosDeportesFragment())
    }
    fun onClickButtonDesarrollo(view: View) {
        // Código que se ejecuta cuando el botón es presionado
        replaceFragmentHome(cursosDesarrolloFragment())

    }

    fun onClickButtonMisPublicaciones(view: View){
        replaceFragmentHome(mis_publicacionesFragment())
    }
    fun onClickButtonPublicacionesGenerales(view: View){
        replaceFragmentHome(publicaciones_generalesFragment())
    }

    private fun getUser(): User? {
        val sp = getSharedPreferences("CampusBu", MODE_PRIVATE)
        val json = sp.getString("user", null)
        return if (json != null) {
            Gson().fromJson(json, User::class.java)
        } else {
            null
        }
    }


}