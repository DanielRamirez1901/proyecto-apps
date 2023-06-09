package com.example.interfaces_pr.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder

import com.example.interfaces_pr.databinding.FormatNotificationBinding

class NotificationViewHolder(root: View) : ViewHolder(root){
    private val binding = FormatNotificationBinding.bind(root)
    val userProfileImg = binding.userProfileImg
    val typeActivityImg = binding.typeActivityImg
    val activityImg = binding.activityImg
    val courseTypeTxt = binding.courseTypeTxt
    val courseNameTxt = binding.courseNameTxt
    val notificationDescTxt = binding.notificationDescTxt

}

