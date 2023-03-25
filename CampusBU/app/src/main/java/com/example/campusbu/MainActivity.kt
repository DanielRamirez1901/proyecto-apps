package com.example.campusbu

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
import com.example.campusbu.Fragments.*
import com.example.campusbu.R.id

class MainActivity : AppCompatActivity() {

    private lateinit var button_home: ImageButton
    private lateinit var button_publi: ImageButton
    private lateinit var button_noti: ImageButton
    private lateinit var button_perfil: ImageButton
    private lateinit var button_Cultura: Button
    private lateinit var button_Deportes: Button
    private lateinit var button_Desarrollo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val homeFragment = inflater.inflate(R.layout.homefragment, null)

        button_home = findViewById(id.button_home)
        button_publi = findViewById(id.button_publi)
        button_noti = findViewById(id.button_noti)
        button_perfil = findViewById(id.button_perfil)
        button_Cultura = homeFragment.findViewById(id.button_Cultura)
        button_Deportes = homeFragment.findViewById(id.button_deportes)
        button_Desarrollo = homeFragment.findViewById(id.button_desarrollo)

        supportFragmentManager.beginTransaction()
            .replace(id.fragment_container, HomeFragment())
            .commit()
        button_home.setColorFilter(ContextCompat.getColor(this,R.color.azulito), PorterDuff.Mode.SRC_IN)
        button_Cultura.setBackgroundResource(R.drawable.borde_navegation_of_home)


        button_home.setOnClickListener {
            replaceFragment(HomeFragment())
            button_home.setColorFilter(ContextCompat.getColor(this,R.color.azulito), PorterDuff.Mode.SRC_IN)
            button_noti.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            button_perfil.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            button_publi.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)

        }
        button_publi.setOnClickListener {
            replaceFragment(PubliFragment())
            button_home.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            button_publi.setColorFilter(ContextCompat.getColor(this,R.color.azulito), PorterDuff.Mode.SRC_IN)
            button_noti.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            button_perfil.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)

        }
        button_noti.setOnClickListener {
            replaceFragment(NotiFragment())
            button_home.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            button_publi.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)
            button_noti.setColorFilter(ContextCompat.getColor(this,R.color.azulito), PorterDuff.Mode.SRC_IN)
            button_perfil.setColorFilter(ContextCompat.getColor(this,R.color.grisesito), PorterDuff.Mode.SRC_IN)

        }
        button_perfil.setOnClickListener {
            replaceFragment(PerfilFragment())
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
        button_Cultura.setBackgroundResource(R.drawable.borde_navegation_of_home)
        button_Deportes.setBackgroundResource(R.color.white)
        button_Desarrollo.setBackgroundResource(R.color.white)
        replaceFragmentHome(PubliFragment())
    }
    fun onClickButtonDeportes(view: View) {
        // Código que se ejecuta cuando el botón es presionado
        button_Cultura.setBackgroundResource(R.color.white)
        button_Deportes.setBackgroundResource(R.drawable.borde_navegation_of_home)
        button_Desarrollo.setBackgroundResource(R.color.white)
        replaceFragmentHome(NotiFragment())
    }
    fun onClickButtonDesarrollo(view: View) {
        // Código que se ejecuta cuando el botón es presionado
        button_Cultura.setBackgroundResource(R.color.white)
        button_Deportes.setBackgroundResource(R.color.white)
        button_Desarrollo.setBackgroundResource(R.drawable.borde_navegation_of_home)
        replaceFragmentHome(PerfilFragment())

    }
}
