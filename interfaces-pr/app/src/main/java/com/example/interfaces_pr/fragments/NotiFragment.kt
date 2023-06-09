package com.example.interfaces_pr.fragments


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.interfaces_pr.adapter.NotificationAdapter
import com.example.interfaces_pr.databinding.ListItemNotificationBinding
import com.example.interfaces_pr.model.CoursePublicationGeneral
import com.example.interfaces_pr.model.NotificationAtri
import com.example.interfaces_pr.model.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson

class NotiFragment : Fragment() {
    private lateinit var binding: ListItemNotificationBinding
    private lateinit var notificationAdapter: NotificationAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento
        binding = ListItemNotificationBinding.inflate(inflater, container, false)

        adapterNotification()
        startConnection()


        return binding.root
    }

    private fun adapterNotification(){
        notificationAdapter = NotificationAdapter()
        binding.notificationListView.adapter = notificationAdapter
        binding.notificationListView.setHasFixedSize(false)
        binding.notificationListView.layoutManager = LinearLayoutManager(requireContext())
    }
    private fun startConnection() {
        var counterPublications: Int = 0
        val userActual = getUser()
        Log.d(">>>", "${userActual?.id!!}: Estoy en notifragment")
        val notificationsRef = Firebase.firestore.collection("Notifications").document(userActual?.id!!)

        notificationsRef.collection("Comment").get().addOnCompleteListener { task ->
            for (doc in task.result!!) {
                val notification = doc.toObject(NotificationAtri::class.java)
                counterPublications++
                notificationAdapter.addNotification(notification)
            }
            notificationsRef.collection("Reaction").get().addOnCompleteListener { task ->
                for (doc in task.result!!) {
                    val notification = doc.toObject(NotificationAtri::class.java)
                    counterPublications++
                    notificationAdapter.addNotification(notification)
                }
                notificationsRef.collection("ReactionsInComment").get().addOnCompleteListener { task ->
                    for (doc in task.result!!) {
                        val notification = doc.toObject(NotificationAtri::class.java)
                        counterPublications++
                        notificationAdapter.addNotification(notification)
                    }

                    if (counterPublications == 1) {
                        binding.contadorNotificaciones.text = "Tiene $counterPublications notificación"
                    } else {
                        binding.contadorNotificaciones.text = "Tiene $counterPublications notificaciones"
                    }
                }
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
