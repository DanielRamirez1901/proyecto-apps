package com.example.interfaces_pr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.interfaces_pr.adapter.CourseCommentAdapter
import com.example.interfaces_pr.adapter.OnItemButtonListener
import com.example.interfaces_pr.databinding.ActivityPublicationsBinding
import com.example.interfaces_pr.model.CourseComment
import com.example.interfaces_pr.model.CoursePublicationGeneral
import com.example.interfaces_pr.model.NotificationAtri
import com.example.interfaces_pr.model.User
import com.example.interfaces_pr.viewholders.CourseCommentViewHolder
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import java.util.UUID

class PublicationsActivity : AppCompatActivity(),OnItemButtonListener{


    private lateinit var coursePublicationG:CoursePublicationGeneral
    private var courseTypeP:String? = null
    private var userActual:User?=null

    private val binding by lazy{
        ActivityPublicationsBinding.inflate(layoutInflater)
    }

    private lateinit var courseCommentAdapter:CourseCommentAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        coursePublicationG =intent.extras?.get("coursePublicationG") as CoursePublicationGeneral
        courseTypeP = intent.extras?.getString("courseType")
        userActual = getUser()

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
            likePublication()
        }

        if(coursePublicationG.comprobateUserExist(userActual?.id!!)){
            binding.likeImg.setImageResource(R.drawable.like_icon)
        }else{
            binding.likeImg.setImageResource(R.drawable.unlike_icon)
        }
        binding.reactionsTxt.text = coursePublicationG.usersLikes.size.toString()



        adapterCourseComment()

        binding.sendCommentBtn.setOnClickListener{
           sendCommentFunction()
        }
        startConnectionComments()
    }

    private fun likePublication(){
        Log.d(">>>", coursePublicationG.comprobateUserExist(userActual?.id!!).toString())
        if(coursePublicationG.comprobateUserExist(userActual?.id!!)){
            binding.likeImg.setImageResource(R.drawable.unlike_icon)
            coursePublicationG.addOrDelUserLike(userActual?.id!!,false)
        }else{
            binding.likeImg.setImageResource(R.drawable.like_icon)
            coursePublicationG.addOrDelUserLike(userActual?.id!!,true)
            if(coursePublicationG.userID!=userActual?.id){
                val notificationUser = NotificationAtri(0,"","", userActual?.id!!,coursePublicationG.publicationID)
                Firebase.firestore.collection("Notifications").document(coursePublicationG.userID).collection("Reaction").document(userActual?.id!!).set(notificationUser)
            }
        }
        binding.reactionsTxt.text = coursePublicationG.usersLikes.size.toString()
        Firebase.firestore.collection("Courses").document(courseTypeP.toString()).collection(coursePublicationG.courseName).document(coursePublicationG.publicationID).set(coursePublicationG)
        Log.d(">>>",coursePublicationG.usersLikes.toString())
    }

    private fun adapterCourseComment(){
        courseCommentAdapter = CourseCommentAdapter()
        courseCommentAdapter.commentButtonClickListener = this  // Configurar el listener
        binding.usersCommentsList.adapter = courseCommentAdapter
        binding.usersCommentsList.setHasFixedSize(false)
        binding.usersCommentsList.layoutManager = LinearLayoutManager(this)
    }

    private fun sendCommentFunction(){
        val textInComment = binding.userCommentToSendTxt.text?.toString().orEmpty()
        val commentID = UUID.randomUUID().toString()
        if (textInComment.isNotEmpty()) {
            val timestamp = System.currentTimeMillis() // Obtener la marca de tiempo actual
            val minutesElapsed = getMinutesElapsedFromTimestamp(timestamp)

            val newComment = CourseComment(R.drawable.profile1, R.drawable.unlike_icon, userActual?.username!!, textInComment, getFormattedTimeElapsed(minutesElapsed), "0",userActual?.id!!,
                ArrayList(),commentID
            )
            Firebase.firestore.collection("Courses").document(courseTypeP.toString()).collection(coursePublicationG.courseName).document(coursePublicationG.publicationID).collection("Comments").document(commentID).set(newComment)
            if(coursePublicationG.userID!=userActual?.id){
                val notificationUser = NotificationAtri(0,"","",userActual?.id!!,commentID)
                Firebase.firestore.collection("Notifications").document(coursePublicationG.userID).collection("Comment").document(userActual?.id!!).set(notificationUser)
            }
            Log.d(">>>","ID user: ${userActual?.id}")
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

    override fun onCommentButtonClick(commentHolder: CourseCommentViewHolder, commentObject: CourseComment) {
        if(commentObject.comprobateUserExist(userActual?.id!!)){
            commentHolder.like_inComment.setImageResource(R.drawable.unlike_icon)
            commentObject.addOrDelUserLike(userActual?.id!!,false)
        }else{
            commentHolder.like_inComment.setImageResource(R.drawable.like_icon)
            commentObject.addOrDelUserLike(userActual?.id!!,true)
        }
        commentHolder.numberLike_inComment.text = commentObject.usersLikes.size.toString()
        Firebase.firestore.collection("Courses").document(courseTypeP.toString()).collection(coursePublicationG.courseName).document(coursePublicationG.publicationID).collection("Comments").document(commentObject.commentID).set(commentObject)
    }


}