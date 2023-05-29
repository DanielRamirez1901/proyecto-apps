package com.example.interfaces_pr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.interfaces_pr.databinding.ActivityCourseBinding
import com.example.interfaces_pr.databinding.ActivityPostCommentBinding
import com.example.interfaces_pr.model.CoursePublicationGeneral
import com.example.interfaces_pr.model.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import java.util.Calendar

class PostComment : AppCompatActivity() {

    private lateinit var courseName:String
    private lateinit var courseType:String

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
            publish()
            goToCourseActivity()
        }

        binding.backButton.setOnClickListener{
            goToCourseActivity()
        }

    }


    private fun publish(){
        val user = getUser()

        val calendar = Calendar.getInstance()
        val userImg = R.drawable.profile1
        val publiImg = R.drawable.basketball_course_image
        val day = calendar.get(Calendar.DAY_OF_MONTH).toString()
        val month = (calendar.get(Calendar.MONTH) + 1).toString()
        val year = calendar.get(Calendar.YEAR).toString()
        courseName = intent.extras?.getString("course name").toString()
        courseType = intent.extras?.getString("course type").toString()
        val publiCont = binding.publiContTxt.text.toString()

        val publication = user?.let {
            CoursePublicationGeneral(userImg,publiImg, it.username,day,month,year,publiCont,courseName,it.id)
        }
        if (publication != null) {
            Firebase.firestore.collection("Courses").document(courseType).collection(courseName).document().set(publication)
        }

    }

    private fun goToCourseActivity(){
        val intent = Intent(this,CourseActivity::class.java).apply {
            putExtra("course name",courseName)
            putExtra("course type",courseType)
        }
        startActivity(intent)
    }

    fun getUser(): User? {
        val sp = getSharedPreferences("CampusBu", MODE_PRIVATE)
        val json = sp.getString("user", null)
        return if (json != null) {
            Gson().fromJson(json, User::class.java)
        } else {
            null
        }
    }



    /*
        init{
        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH).toString()
        val month = (calendar.get(Calendar.MONTH) + 1).toString()
        val year = calendar.get(Calendar.YEAR).toString()
        generalPublications.add(CoursePublicationGeneral(R.drawable.profile2,R.drawable.basketball_course_image,"Pepito1",day,month,year,"Esta es una publicacion random que se debe ubicar en los comentarios de la publicacion"))
        generalPublications.add(CoursePublicationGeneral(R.drawable.profile1,R.drawable.football_course_image,"Pepito2",day,month,year,"Esta es una publicacion random que se debe ubicar en los comentarios de la publicacion"))
        generalPublications.add(CoursePublicationGeneral(R.drawable.profile1,R.drawable.basketball_course_image,"Pepito3",day,month,year,"Esta es una publicacion random que se debe ubicar en los comentarios de la publicacion"))

    }
     */
}