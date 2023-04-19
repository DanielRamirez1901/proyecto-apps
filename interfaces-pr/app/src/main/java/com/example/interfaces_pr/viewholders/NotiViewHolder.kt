package com.example.interfaces_pr.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder

import com.example.interfaces_pr.databinding.FormatNotificationBinding

class NotificationViewHolder(root: View) : ViewHolder(root){
    private val binding = FormatNotificationBinding.bind(root)
    val image = binding.iconNotification
    val title = binding.titleNotification
    val description = binding.descriptionNotification

}

