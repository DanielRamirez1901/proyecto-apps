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
    private lateinit var publications:ArrayList<CoursePublicationGeneral>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Aqui dependiendo de a que curso acceda, le paso los parametros al curso y el mismo los setea
        courseName = intent.extras?.getString("course name")
        courseTypeP = intent.extras?.getString("course type")

        val courseType: String = "Basketball"
        val courseDescr: String = getCourseDescription(courseType)
        val courseimg: Int = getCourseImage(courseType)
        val course = Course(binding, courseimg, courseType, courseDescr)
        course.setCourse()

        val itemDecoration = ItemOffsetDecoration(16)
        val layoutManagerMemberTeamAdapter =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val layoutManagerCoursePublicationAdapter =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

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

        coursePublicationsGeneralAdapter = CoursePublicationGeneralAdapter()
        coursePublicationsGeneralAdapter.listener = this
        binding.publicationsGeneralList.adapter = coursePublicationsGeneralAdapter
        binding.publicationsGeneralList.setHasFixedSize(true)
        binding.publicationsGeneralList.layoutManager = LinearLayoutManager(this)
        binding.publicationsGeneralList.addItemDecoration(itemDecoration)

        binding.addPublishBtn.setOnClickListener {
            goToPublishActivity()
        }

        binding.returnBtn.setOnClickListener {
            val intent = Intent(this, MainActivity1::class.java)
            startActivity(intent)
        }

        Log.d(">>>","Estoy en: ${courseName.toString()}")
        Log.d(">>>","En type: $courseTypeP")
        Firebase.firestore.collection("Courses").document(courseTypeP.toString()).collection(courseName.toString()).get().addOnCompleteListener{task ->
            Log.d(">>>", "Llega aqui?")
            for(doc in task.result!!){
                Log.d(">>>", "Llega aqui? for")

                val publication = doc.toObject(CoursePublicationGeneral::class.java)
                coursePublicationsGeneralAdapter.addPublication(publication)
                Log.d(">>>", publication.toString())



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

    override fun onItemClick(coursePublications: cursoAtri) {
        TODO("Not yet implemented")
    }

    override fun onItemClick(courseGeneralPublications: CoursePublicationGeneral) {
        val publicationTitle = courseGeneralPublications.pubGeneral_username
        val publicationCont = courseGeneralPublications.pubGeneral_description
        val userImg = courseGeneralPublications.pubGeneral_userImg
        val publicationImg = courseGeneralPublications.pubGeneral_Img

        val intent = Intent(this,PublicationsActivity::class.java)

        intent.putExtra("publicationTitle",publicationTitle)
        intent.putExtra("publicationCont",publicationCont)
        intent.putExtra("userImg",userImg)
        intent.putExtra("publicationImg",publicationImg)
        startActivity(intent)

    }


}