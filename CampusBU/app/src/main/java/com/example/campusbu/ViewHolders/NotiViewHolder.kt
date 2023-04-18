package com.example.campusbu.ViewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.campusbu.databinding.FormatNotificationBinding
import com.example.campusbu.model.NotificationAtri

class NotificationViewHolder(root: View) : ViewHolder(root){
    private val binding = FormatNotificationBinding.bind(root)
    val image = binding.iconNotification
    val title = binding.titleNotification
    val description = binding.descriptionNotification

}

