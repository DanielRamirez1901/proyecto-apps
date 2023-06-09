package com.example.interfaces_pr.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.interfaces_pr.adapter.CoursePublicationGeneralAdapter
import com.example.interfaces_pr.databinding.DesarrolloCursosBinding
import com.example.interfaces_pr.databinding.PublicacionesGeneralesBinding
import com.example.interfaces_pr.model.CoursePublicationGeneral
import com.example.interfaces_pr.model.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson

class publicaciones_generalesFragment   : Fragment() {

    private lateinit var binding: PublicacionesGeneralesBinding // declara la variable binding
    private lateinit var publicationsAdapter: CoursePublicationGeneralAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = PublicacionesGeneralesBinding.inflate(
            inflater,
            container,
            false
        ) // inicializa la variable binding
        adapterPublications()
        startConnectionPublications()
        return binding.root // retorna la vista inflada a través de la variable binding
    }

    private fun adapterPublications() {
        publicationsAdapter = CoursePublicationGeneralAdapter()
        binding.othersPublisListView.adapter = publicationsAdapter
        binding.othersPublisListView.setHasFixedSize(false)
        binding.othersPublisListView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun startConnectionPublications() {
        val userActual = getUser()
        Firebase.firestore.collection("UserPublications").document(userActual?.id!!)
            .collection("Others Publications").get().addOnCompleteListener { task ->
            for (doc in task.result!!) {
                val publications = doc.toObject(CoursePublicationGeneral::class.java)
                publicationsAdapter.addPublication(publications)
            }
        }
    }

    private fun getUser(): User? {
        val sp = activity?.getSharedPreferences("CampusBu", AppCompatActivity.MODE_PRIVATE)
        val json = sp?.getString("user", null)
        return if (json != null) {
            Gson().fromJson(json, User::class.java)
        } else {
            null
        }

    }
}