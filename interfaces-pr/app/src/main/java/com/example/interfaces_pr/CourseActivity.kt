package com.example.interfaces_pr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.interfaces_pr.adapter.*
import com.example.interfaces_pr.databinding.ActivityCourseBinding
import com.example.interfaces_pr.model.Course
import com.example.interfaces_pr.model.CoursePublicationGeneral
import com.example.interfaces_pr.recyclerview.ItemOffsetDecoration
import com.example.interfaces_pr.model.CoursePublications
import com.example.interfaces_pr.model.cursoAtri
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class CourseActivity : AppCompatActivity(),OnItemClickListener{



    private val binding by lazy{
        ActivityCourseBinding.inflate(layoutInflater)
    }

    private lateinit var scheduleAdapter:CourseScheduleAdapter
    private lateinit var teacherAdapter:TeacherAdapter
    private lateinit var memberTeamAdapter:MemberTeamAdapter
    private lateinit var coursePublicationsAdapter:CoursePublicationAdapter
    private lateinit var coursePublicationsGeneralAdapter:CoursePublicationGeneralAdapter
    private var courseName:String? = null
    private var courseTypeP:String? = null
    private val itemDecoration=ItemOffsetDecoration(16)
    private lateinit var coursePublicationsG: ArrayList<CoursePublicationGeneral>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        courseName = intent.extras?.getString("course name")
        courseTypeP = intent.extras?.getString("course type")


        val courseDescr: String = getCourseDescription(courseName!!)
        val courseImg: Int = getCourseImage(courseName!!)
        val course = Course(binding, courseImg, courseName!!, courseDescr)
        course.setCourse()


        val layoutManagerMemberTeamAdapter =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val layoutManagerCoursePublicationAdapter =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)



        adapterCourseSchedule()
        adapterTeacher()
        adapterMemberTeam(layoutManagerMemberTeamAdapter,courseImg)
        adapterCoursePublication(layoutManagerCoursePublicationAdapter)
        adapterCoursePublicationGeneral()

        binding.addPublishBtn.setOnClickListener {
            goToPublishActivity()
        }

        binding.returnBtn.setOnClickListener {
            val intent = Intent(this,MainActivity1::class.java)
            startActivity(intent)
        }

        startConnectionPublications()

    }

    //*********************** Adapters Init Here **************************

    private fun adapterCourseSchedule(){
        scheduleAdapter = CourseScheduleAdapter()
        binding.courseScheduleList.adapter = scheduleAdapter
        binding.courseScheduleList.setHasFixedSize(true)
        binding.courseScheduleList.addItemDecoration(itemDecoration)
    }

    private fun adapterTeacher(){
        teacherAdapter = TeacherAdapter()
        binding.teachersList.adapter = teacherAdapter
        binding.teachersList.setHasFixedSize(false)
        binding.teachersList.layoutManager = LinearLayoutManager(this)
        binding.teachersList.addItemDecoration(itemDecoration)
    }

    private fun adapterMemberTeam(layoutManagerMemberTeamAdapter:LinearLayoutManager,courseImg:Int){
        memberTeamAdapter = MemberTeamAdapter()
        binding.teamIcesiList.adapter = memberTeamAdapter
        binding.teamIcesiList.setHasFixedSize(true)
        binding.teamIcesiList.layoutManager = layoutManagerMemberTeamAdapter
        binding.teamBannerIMG.setImageResource(courseImg)
    }
    private fun adapterCoursePublication(layoutManagerCoursePublicationAdapter:LinearLayoutManager){
        coursePublicationsAdapter = CoursePublicationAdapter()
        coursePublicationsAdapter.listener = this
        binding.importantPbList.adapter = coursePublicationsAdapter
        binding.importantPbList.setHasFixedSize(true)
        binding.importantPbList.addItemDecoration(itemDecoration)
        binding.importantPbList.layoutManager = layoutManagerCoursePublicationAdapter
    }
    private fun adapterCoursePublicationGeneral(){
        coursePublicationsGeneralAdapter = CoursePublicationGeneralAdapter()
        coursePublicationsGeneralAdapter.listener = this
        binding.publicationsGeneralList.adapter = coursePublicationsGeneralAdapter
        binding.publicationsGeneralList.setHasFixedSize(true)
        binding.publicationsGeneralList.layoutManager = LinearLayoutManager(this)
        binding.publicationsGeneralList.addItemDecoration(itemDecoration)
    }

    //*********************************************************************

    private fun startConnectionPublications(){
        Firebase.firestore.collection("Courses").document(courseTypeP.toString()).collection(courseName.toString()).get().addOnCompleteListener{task ->
            for(doc in task.result!!){
                val publication = doc.toObject(CoursePublicationGeneral::class.java)
                coursePublicationsGeneralAdapter.addPublication(publication)
            }
        }
    }

     fun irAPrimeraActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun goToPublishActivity(){
        val intent = Intent(this,PostComment::class.java).apply {
            putExtra("course name",courseName)
            putExtra("course type",courseTypeP)
        }
        startActivity(intent)
    }

    private fun getCourseDescription(courseType: String): String {
        val courseDescriptions = mapOf(
            "Futbol" to "Esta es la descripción del curso futbol",
            "Basketball" to "Esta es la descripción del curso basket",
            "Tennis" to "Esta es la descripción del curso de Tennis",
            "Tiro con Arco" to "Esta es la descripción del curso de Tiro con Arco",
            "Artes Escenicas" to "Esta es la descripción del curso de Artes Escenicas",
            "Artes Visuales" to "Esta es la descripción del curso de Artes Visuales",
            "Artes Plasticas" to "Esta es la descripción del curso de Artes Plasticas",
            "Desarrollo Personal" to "Esta es la descripción del curso de Desarrollo Personal",
            "Acompañamiento" to "Esta es la descripción del curso de Acompañamiento",
            "Induccion" to "Esta es la descripción del curso de Induccion"
        )
        return courseDescriptions.getOrElse(courseType) { "" }
    }


    private fun getCourseImage(courseType: String): Int {
        val courseImages = mapOf(
            "Futbol" to R.drawable.football_course_image,
            "Basketball" to R.drawable.basketball_course_image,
            "Tennis" to R.drawable.tennis_course_image,
            "Tiro con Arco" to R.drawable.tiro_course_image,
            "Artes Escenicas" to R.drawable.escenicas_course_image,
            "Artes Visuales" to R.drawable.visuales_course_image,
            "Artes Plasticas" to R.drawable.plasticas_course_image,
            "Desarrollo Personal" to R.drawable.personal_course_image,
            "Acompañamiento" to R.drawable.acompanamiento_course_image,
            "Induccion" to R.drawable.induccion_course_image,
        )

        return courseImages[courseType] ?: 0
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

    override fun onItemClick(coursePublications: cursoAtri) {
        TODO("Not yet implemented")
    }

    override fun onItemClick(coursePublicationsG: CoursePublicationGeneral) {

        val intent = Intent(this, PublicationsActivity::class.java)
        intent.putExtra("coursePublicationG", coursePublicationsG)

        startActivity(intent)
    }



}