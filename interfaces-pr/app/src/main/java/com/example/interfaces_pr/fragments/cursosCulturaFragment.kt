package com.example.interfaces_pr.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.interfaces_pr.CourseActivity
import com.example.interfaces_pr.databinding.CulturaCursosBinding
import com.example.interfaces_pr.model.CoursePublicationGeneral
import com.example.interfaces_pr.model.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson

class cursosCulturaFragment  : Fragment() {

    private lateinit var binding: CulturaCursosBinding // declara la variable binding
    private val courseType:String = "Cultura"
    private var courseArraList = ArrayList<String>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = CulturaCursosBinding.inflate(inflater, container, false) // inicializa la variable binding


        binding.artesEscenicasImg.setOnClickListener{
            println("wenas")
            val courseName = "Artes Escenicas"
            creationCourseInDb(courseType)
            goToCourse(courseName,courseType)
        }
        binding.artesVisualesImg.setOnClickListener{
            println("wenas")
            val courseName = "Artes Visuales"
            creationCourseInDb(courseType)
            goToCourse(courseName,courseType)
        }
        binding.desarrolloImg.setOnClickListener{
            println("wenas")
            val courseName = "Artes Plasticas"
            creationCourseInDb(courseType)
            goToCourse(courseName,courseType)
        }
        return binding.root // retorna la vista inflada a través de la variable binding

    }
    private fun goToCourse(courseName:String,courseType:String){
        val intent = Intent(this.activity,CourseActivity::class.java).apply {
            putExtra("course name",courseName)
            putExtra("course type",courseType)
        }



        startActivity(intent)
    }

    private fun creationCourseInDb(typeActivity:String){
        val user = this?.getUser()
        user?.username?.let { Log.d(">>>", it) }

        val coursePubliInit = user?.let {
            CoursePublicationGeneral(0,0, it.username,
                "","","","","Any",it.id)
        }

        val course1 = "Artes Escenicas"
        val course2 = "Artes Visuales"
        val course3 = "Artes Plasticas"
        courseArraList.add(course1)
        courseArraList.add(course2)
        courseArraList.add(course3)

        val query = Firebase.firestore.collection("Courses").whereEqualTo("typeActivity",typeActivity)
        query.get().addOnCompleteListener{task->
            if(task.result.size()==0){
                for(i in courseArraList.indices){

                    if (coursePubliInit != null) {
                        Firebase.firestore.collection("Courses").document(typeActivity).collection(courseArraList[i])
                    }

                }
            }
        }

    }

    private fun getUser(): User? {
        val sp = activity?.getSharedPreferences("CampusBu", AppCompatActivity.MODE_PRIVATE)
        val json = sp?.getString("user", null)
        return if (json != null) {
            Gson().fromJson(json, User::class.java)
        } else {
            null
        }
    }

}
