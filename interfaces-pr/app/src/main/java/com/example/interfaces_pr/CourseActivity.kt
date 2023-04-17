package com.example.interfaces_pr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.interfaces_pr.adapter.CoursePublicationAdapter
import com.example.interfaces_pr.adapter.CourseScheduleAdapter
import com.example.interfaces_pr.adapter.MemberTeamAdapter
import com.example.interfaces_pr.adapter.TeacherAdapter
import com.example.interfaces_pr.databinding.ActivityCourseBinding
import com.example.interfaces_pr.model.Course
import com.example.interfaces_pr.recyclerview.ItemOffsetDecoration
import com.example.interfaces_pr.adapter.OnItemClickListener
import com.example.interfaces_pr.model.CoursePublications
import com.example.interfaces_pr.model.Teacher
import com.example.interfaces_pr.recyclerview.PublicationInterface


class CourseActivity : AppCompatActivity(),OnItemClickListener{



    private val binding by lazy{
        ActivityCourseBinding.inflate(layoutInflater)
    }

    private lateinit var scheduleAdapter:CourseScheduleAdapter
    private lateinit var teacherAdapter:TeacherAdapter
    private lateinit var memberTeamAdapter:MemberTeamAdapter
    private lateinit var coursePublicationsAdapter:CoursePublicationAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Aqui dependiendo de a que curso acceda, le paso los parametros al curso y el mismo los setea
        val courseType : String = "Soccer"
        val courseDescr : String = getCourseDescription(courseType)
        val courseimg : Int = getCourseImage(courseType)
        val course = Course(binding,courseimg,courseType,courseDescr)
        course.setCourse()

        val itemDecoration = ItemOffsetDecoration(16)
        val layoutManagerMemberTeamAdapter = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        val layoutManagerCoursePublicationAdapter = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        scheduleAdapter = CourseScheduleAdapter(courseType)
        binding.courseScheduleList.adapter = scheduleAdapter
        binding.courseScheduleList.setHasFixedSize(true)
        binding.courseScheduleList.addItemDecoration(itemDecoration)


        teacherAdapter = TeacherAdapter(courseType)
        binding.teachersList.adapter = teacherAdapter
        binding.teachersList.setHasFixedSize(false)
        binding.teachersList.layoutManager = LinearLayoutManager(this)
        binding.teachersList.addItemDecoration(itemDecoration)

        memberTeamAdapter = MemberTeamAdapter(courseType)
        binding.teamIcesiList.adapter = memberTeamAdapter
        binding.teamIcesiList.setHasFixedSize(true)
        binding.teamIcesiList.layoutManager = layoutManagerMemberTeamAdapter
        binding.teamBannerIMG.setImageResource(courseimg)

        coursePublicationsAdapter = CoursePublicationAdapter()
        coursePublicationsAdapter.listener = this
        binding.importantPbList.adapter = coursePublicationsAdapter
        binding.importantPbList.setHasFixedSize(true)
        binding.importantPbList.addItemDecoration(itemDecoration)
        binding.importantPbList.layoutManager = layoutManagerCoursePublicationAdapter




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

    override fun onItemClick(coursePublications: CoursePublications) {
        val publicationTitle = coursePublications.userName
        val publicationCont = coursePublications.pbContent
        val userImg = coursePublications.pbUser
        val publicationImg = coursePublications.imagePublic
        val intent = Intent(this, PublicationsActivity::class.java)

        intent.putExtra("publicationTitle",publicationTitle)
        intent.putExtra("publicationCont",publicationCont)
        intent.putExtra("userImg",userImg)
        intent.putExtra("publicationImg",publicationImg)

        startActivity(intent)
    }


}