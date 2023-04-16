package com.example.interfaces_pr.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.interfaces_pr.databinding.TeacherBinding

class TeacherViewHolder(root:View):ViewHolder(root) {

    private val binding = TeacherBinding.bind(root)
    val teacherName = binding.teacherNameTxt
    val teacherDesc = binding.teacherDescTxt
    val backImg = binding.imageBack
    val profileImg = binding.userProfile

}