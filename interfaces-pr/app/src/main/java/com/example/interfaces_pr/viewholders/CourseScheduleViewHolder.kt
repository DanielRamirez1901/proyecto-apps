package com.example.interfaces_pr.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.interfaces_pr.databinding.CourseScheduleBinding

class CourseScheduleViewHolder(root:View) : ViewHolder(root){

    private val binding = CourseScheduleBinding.bind(root)
    val hour1 = binding.hour1txt
    val hour2 = binding.hour2txt
    val day = binding.daytxt
    val teacher = binding.teachertxt
}