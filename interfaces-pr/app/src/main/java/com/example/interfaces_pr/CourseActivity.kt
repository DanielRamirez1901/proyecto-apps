package com.example.interfaces_pr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.interfaces_pr.adapter.CourseScheduleAdapter
import com.example.interfaces_pr.databinding.ActivityCourseBinding
import com.example.interfaces_pr.model.Course
import com.example.interfaces_pr.recyclerview.ItemOffsetDecoration

class CourseActivity : AppCompatActivity() {



    private val binding by lazy{
        ActivityCourseBinding.inflate(layoutInflater)
    }

    private lateinit var adapter:CourseScheduleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Aqui dependiendo de a que curso acceda, le paso los parametros al curso y el mismo los setea
        val courseType : String = "Soccer"
        val courseDescr : String = getCourseDescription(courseType)
        val courseimg : Int = getCourseImage(courseType)
        val course = Course(binding,courseimg,courseType,courseDescr)
        course.setCourse()


        adapter = CourseScheduleAdapter(courseType)
        binding.courseScheduleList.adapter = adapter
        binding.courseScheduleList.setHasFixedSize(true)

        val itemDecoration = ItemOffsetDecoration(16)
        binding.courseScheduleList.addItemDecoration(itemDecoration)
    }

    fun irAPrimeraActivity(view: View) {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

    fun getCourseDescription(courseType : String):String{
        var type:String = ""
        if(courseType == "Soccer"){
            type="Esta es la descripcion del curso futbol"
        }else if(courseType == "Basketball"){
            type="Esta es la descripcion del curso basket"
        }
        return type
    }

    fun getCourseImage(courseType:String): Int {
        var image : Int = 0
        if(courseType == "Soccer"){
            image = R.drawable.football_course_image
        }else if(courseType == "Basketball"){
            image = R.drawable.basketball_course_image
        }
        return image
    }
}