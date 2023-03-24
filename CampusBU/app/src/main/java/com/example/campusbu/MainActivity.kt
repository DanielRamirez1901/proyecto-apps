package com.example.campusbu

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.campusbu.Fragments.*

class MainActivity : AppCompatActivity() {

    private lateinit var button_home: ImageButton
    private lateinit var button_publi: ImageButton
    private lateinit var button_noti: ImageButton
    private lateinit var button_perfil: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_home = findViewById(R.id.button_home)
        button_publi = findViewById(R.id.button_publi)
        button_noti = findViewById(R.id.button_noti)
        button_perfil = findViewById(R.id.button_perfil)

        // Establecer el fragmento inicial
        val homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, homeFragment)
            .commit()

        // Manejar el evento de clic en los botones de navegación
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
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
