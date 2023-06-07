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
import com.example.interfaces_pr.model.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import java.util.UUID

class PublicationsActivity : AppCompatActivity() {

    private var numLikes = 0
    private var isLiked = false
    private lateinit var coursePublicationG:CoursePublicationGeneral
    private var courseTypeP:String? = null

    private val binding by lazy{
        ActivityPublicationsBinding.inflate(layoutInflater)
    }

    private lateinit var courseCommentAdapter:CourseCommentAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        coursePublicationG =intent.extras?.get("coursePublicationG") as CoursePublicationGeneral
        courseTypeP = intent.extras?.getString("courseType")

        binding.publicationTitleTxt.text = coursePublicationG.pubGeneral_username
        binding.publicationContTxt.text = coursePublicationG.pubGeneral_description
        binding.userImg.setImageResource(coursePublicationG.pubGeneral_userImg)
        binding.userCommentImg.setImageResource(coursePublicationG.pubGeneral_userImg)
        binding.publicationImg.setImageResource(coursePublicationG.pubGeneral_Img)


        binding.backButton.setOnClickListener{
            val intent = Intent(this,CourseActivity::class.java).apply {
                putExtra("course name",coursePublicationG.courseName)
                putExtra("course type",courseTypeP)
            }

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


        adapterCourseComment()

        binding.sendCommentBtn.setOnClickListener{
           sendCommentFunction()
        }
        startConnectionComments()
    }

    private fun adapterCourseComment(){
        courseCommentAdapter = CourseCommentAdapter()
        binding.usersCommentsList.adapter = courseCommentAdapter
        binding.usersCommentsList.setHasFixedSize(false)
        binding.usersCommentsList.layoutManager = LinearLayoutManager(this)
    }

    private fun sendCommentFunction(){
        val userInComment = getUser()
        val textInComment = binding.userCommentToSendTxt.text?.toString().orEmpty()
        val commentID = userInComment?.id!!+"+"+UUID.randomUUID().toString()
        if (textInComment.isNotEmpty()) {
            val timestamp = System.currentTimeMillis() // Obtener la marca de tiempo actual
            val minutesElapsed = getMinutesElapsedFromTimestamp(timestamp)

            val newComment = CourseComment(R.drawable.profile1, R.drawable.unlike_icon, userInComment?.username!!, textInComment, getFormattedTimeElapsed(minutesElapsed), "0",userInComment.id)
            Firebase.firestore.collection("Courses").document(courseTypeP.toString()).collection(coursePublicationG.courseName).document(coursePublicationG.publicationID).collection("Comments").document(commentID).set(newComment)
            Log.d(">>>","ID user: ${userInComment.id}")
            courseCommentAdapter.addComment(newComment)
            binding.userCommentToSendTxt.text?.clear()
        }
    }
    private fun startConnectionComments(){
        Firebase.firestore.collection("Courses").document(courseTypeP.toString()).collection(coursePublicationG.courseName).document(coursePublicationG.publicationID).collection("Comments").get().addOnCompleteListener{task ->
            var cont = 0
            for(doc in task.result!!){
                val comment = doc.toObject(CourseComment::class.java)
                courseCommentAdapter.addComment(comment)
                cont++
                Log.d(">>>","User $cont : $comment\r")
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

    private fun getUser(): User? {
        val sp = getSharedPreferences("CampusBu", MODE_PRIVATE)
        val json = sp.getString("user", null)
        return if (json != null) {
            Gson().fromJson(json, User::class.java)
        } else {
            null
        }
    }

}