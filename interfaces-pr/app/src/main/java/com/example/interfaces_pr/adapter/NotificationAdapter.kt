package com.example.interfaces_pr.adapter

import android.app.Notification
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.interfaces_pr.R
import com.example.interfaces_pr.viewholders.NotificationViewHolder
import com.example.interfaces_pr.model.NotificationAtri



class NotificationAdapter : Adapter<NotificationViewHolder>(){
    private var noti: ArrayList<NotificationAtri> = arrayListOf()

    /*
    init {
        noti.add(NotificationAtri(R.drawable.futbol_icon, "Notificacion 1", "descripcion 1"))
        noti.add(NotificationAtri(R.drawable.futbol_icon, "Notificacion 2", "descripcion 2"))
        noti.add(NotificationAtri(R.drawable.futbol_icon, "Notificacion 4", "descripcion 4"))

    }

     */

    //crea los esqueletos de items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        //xml --> View
        val view: View = layoutInflater.inflate(R.layout.format_notification, parent, false)
        return NotificationViewHolder(view)
    }

    //Pone datos en el esqueleto
    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.userProfileImg.setImageResource(noti[position].userImg)
        if(noti[position].typeActivity=="Comment"){
            holder.typeActivityImg.setImageResource(R.drawable.comentario_reaction)
            holder.notificationDescTxt.text = "${noti[position].userName} a comentado tu publicación"
        }else{
            holder.typeActivityImg.setImageResource(R.drawable.corazon_notification)
            if(noti[position].typeActivity=="ReactionComment"){
                holder.notificationDescTxt.text = "${noti[position].userName} a reaccionado a tu comentario"
            }else{
                holder.notificationDescTxt.text = "${noti[position].userName} a reaccionado a tu publicación"
            }
        }
        holder.activityImg.setImageResource(noti[position].publicationImg)
        holder.courseTypeTxt.text = noti[position].courseType
        holder.courseNameTxt.text = noti[position].courseName
    }

    override fun getItemCount(): Int {
        return noti.size
    }

    fun addNotification(notification: NotificationAtri){
        noti.add(notification)
        notifyItemInserted(noti.lastIndex)
    }
}

