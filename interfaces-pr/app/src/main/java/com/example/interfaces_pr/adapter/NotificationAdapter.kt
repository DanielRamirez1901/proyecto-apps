package com.example.interfaces_pr.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.interfaces_pr.R
import com.example.interfaces_pr.viewholders.NotificationViewHolder
import com.example.interfaces_pr.model.NotificationAtri

class NotificationAdapter : Adapter<NotificationViewHolder>(){
    private var noti: ArrayList<NotificationAtri> = arrayListOf()

    init {
        noti.add(NotificationAtri(R.drawable.futbol_icon, "Notificacion 1", "descripcion 1"))
        noti.add(NotificationAtri(R.drawable.futbol_icon, "Notificacion 2", "descripcion 2"))
        noti.add(NotificationAtri(R.drawable.futbol_icon, "Notificacion 4", "descripcion 4"))

    }

    //crea los esqueletos de items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        //xml --> View
        val view: View = layoutInflater.inflate(R.layout.format_notification, parent, false)
        return NotificationViewHolder(view)
    }

    //Pone datos en el esqueleto
    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.title.text = noti[position].title
        holder.description.text = noti[position].description
        holder.image.setImageResource(noti[position].icon)

    }

    override fun getItemCount(): Int {
        return noti.size
    }
}

