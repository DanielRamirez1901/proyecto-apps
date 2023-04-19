package com.example.interfaces_pr.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.interfaces_pr.databinding.TeacherPublicationBinding

class CoursePublicationViewHolder(root:View):ViewHolder(root) {

    private val binding = TeacherPublicationBinding.bind(root)
    val pUser = binding.pbUserImg
    val imagePublic = binding.pbImagepbImg
    val userName = binding.pbUserNameTxt
    val day = binding.pbDayTxt
    val month = binding.pbMouthTxt
    val year = binding.pbYearTxt
    val pbContent = binding.pbContentTxt

}