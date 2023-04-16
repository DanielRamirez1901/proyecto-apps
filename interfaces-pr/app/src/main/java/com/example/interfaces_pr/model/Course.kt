package com.example.interfaces_pr.model

import com.example.interfaces_pr.databinding.ActivityCourseBinding

class Course(private val binding: ActivityCourseBinding, val courseImage:Int, val courseName : String, val courseDescription :String) {

    fun setCourse(){
        binding.courseImage.setImageResource(courseImage)
        binding.courseNametxt.text = courseName
        binding.courseDescriptionTxt.text = courseDescription
    }
}