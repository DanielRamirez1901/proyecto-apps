package com.example.interfaces_pr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.interfaces_pr.databinding.ActivityCourseBinding
import com.example.interfaces_pr.databinding.ActivityPostCommentBinding

class PostComment : AppCompatActivity() {



    private val binding by lazy{
        ActivityPostCommentBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.userImg.setImageResource(R.drawable.profile1)
        binding.galleryBtn.setOnClickListener{
            binding.publicationImg.setImageResource(R.drawable.basketball_course_image)
        }

        binding.addBtn.setOnClickListener{
            goToCourseActivity()
        }

        binding.backButton.setOnClickListener{
            goToCourseActivity()
        }

    }

    private fun goToCourseActivity(){
        val intent = Intent(this,CourseActivity::class.java)
        startActivity(intent)
    }
}