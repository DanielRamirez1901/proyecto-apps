package com.example.interfaces_pr.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.interfaces_pr.databinding.CoursePublicationGeneralBinding

class CoursePublicationGeneralViewHolder(root:View):ViewHolder(root) {

    private val binding = CoursePublicationGeneralBinding.bind(root)
     var pubGeneral_userImg = binding.pubgeneralUserImg
     var pubGeneral_Img = binding.pubGeneralImg
     var pubGeneral_username = binding.pubGeneralUsernameTxt
     var pubGeneral_day = binding.pbGeneralDayTxt
     var pubGeneral_month = binding.pbGeneralMouthTxt
     var pubGeneral_year = binding.pbGeneralYearTxt
     var pubGeneral_description = binding.pubGeneralDescriptionTxt
}