package com.example.interfaces_pr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.interfaces_pr.adapter.CourseCommentAdapter
import com.example.interfaces_pr.adapter.CoursePublicationGeneralAdapter
import com.example.interfaces_pr.databinding.ActivityPublicationsBinding
import com.example.interfaces_pr.model.CourseComment
import com.example.interfaces_pr.model.CoursePublicationGeneral

class PublicationsActivity : AppCompatActivity() {

    private var numLikes = 0
    private var isLiked = false
    private lateinit var coursePublicationG:CoursePublicationGeneral

    private val binding by lazy{
        ActivityPublicationsBinding.inflate(layoutInflater)
    }

    private lateinit var courseCommentAdapter:CourseCommentAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        coursePublicationG =intent.extras?.get("coursePublicationG") as CoursePublicationGeneral


        binding.publicationTitleTxt.text = coursePublicationG.pubGeneral_username
        binding.publicationContTxt.text = coursePublicationG.pubGeneral_description
        binding.userImg.setImageResource(coursePublicationG.pubGeneral_userImg)
        binding.userCommentImg.setImageResource(coursePublicationG.pubGeneral_userImg)
        binding.publicationImg.setImageResource(coursePublicationG.pubGeneral_Img)


        binding.backButton.setOnClickListener{
            val intent = Intent(this,CourseActivity::class.java)
            startActivity(intent)
        }

        binding.userImg.setOnClickListener{
            var username = binding.publicationTitleTxt.text.toString()
            Log.d(">>>","Username en publicacion: $username")
            goToUserProfile(username)
        }



        binding.likeImg.setOnClickListener{
            if(isLiked){
                numLikes --
                binding.likeImg.setImageResource(R.drawable.unlike_icon)
                binding.reactionsTxt.text = numLikes.toString()
                isLiked = false
            }else{
                numLikes++
                binding.likeImg.setImageResource(R.drawable.like_icon)
                binding.reactionsTxt.text = numLikes.toString()
                isLiked = true
            }
        }

        courseCommentAdapter = CourseCommentAdapter()
        binding.usersCommentsList.adapter = courseCommentAdapter
        binding.usersCommentsList.setHasFixedSize(true)
        binding.usersCommentsList.layoutManager = LinearLayoutManager(this)





        binding.sendCommentBtn.setOnClickListener{
            val textInComment = binding.userCommentToSendTxt.text?.toString().orEmpty().trim()
            if (textInComment.isNotEmpty()) {
                val timestamp = System.currentTimeMillis() // Obtener la marca de tiempo actual
                val minutesElapsed = getMinutesElapsedFromTimestamp(timestamp)

                val newComment = CourseComment(R.drawable.profile1, R.drawable.unlike_icon, "Pepito", textInComment, getFormattedTimeElapsed(minutesElapsed), "1")
                courseCommentAdapter.addComment(newComment)
                courseCommentAdapter.notifyDataSetChanged()
                binding.userCommentToSendTxt.text?.clear()
            }
        }

    }

    private fun goToUserProfile(username:String){
        val intent = Intent(this,MainActivity1::class.java).apply {
            putExtra("username",username)
        }
        startActivity(intent)
    }

    fun getMinutesElapsedFromTimestamp(timestamp: Long): Long {
        val currentTime = System.currentTimeMillis() / 1000
        val timeElapsedInSeconds = currentTime - timestamp
        return timeElapsedInSeconds / 60
    }

    private fun getFormattedTimeElapsed(minutesElapsed: Long): String {
        return when {
            minutesElapsed < 1 -> "ahora"
            minutesElapsed == 1L -> "hace 1 minuto"
            minutesElapsed < 60 -> "hace ${minutesElapsed} minutos"
            minutesElapsed < 120 -> "hace 1 hora"
            else -> "hace ${minutesElapsed/60} horas y ${minutesElapsed%60} minutos"
        }
    }

}