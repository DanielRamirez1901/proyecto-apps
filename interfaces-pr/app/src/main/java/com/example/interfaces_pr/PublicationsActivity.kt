package com.example.interfaces_pr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.interfaces_pr.adapter.CourseCommentAdapter
import com.example.interfaces_pr.databinding.ActivityPublicationsBinding
import com.example.interfaces_pr.model.CourseComment

class PublicationsActivity : AppCompatActivity() {

    private var numLikes = 0
    private var isLiked = false

    private val binding by lazy{
        ActivityPublicationsBinding.inflate(layoutInflater)
    }

    private lateinit var courseCommentAdapter:CourseCommentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val publicationTitle:String? = intent.extras?.getString("publicationTitle")
        val publicationCont:String? = intent.extras?.getString("publicationCont")
        val userImg:Int? = intent.extras?.getInt("userImg")
        val publicationImg:Int? = intent.extras?.getInt("publicationImg")

        binding.publicationTitleTxt.text = publicationTitle
        binding.publicationContTxt.text = publicationCont
        userImg?.let {
            binding.userImg.setImageResource(userImg)
            binding.userCommentImg.setImageResource(userImg)
        }
        publicationImg?.let {
            binding.publicationImg.setImageResource(publicationImg)
        }

        binding.backButton.setOnClickListener{
            val intent = Intent(this,CourseActivity::class.java)
            startActivity(intent)
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