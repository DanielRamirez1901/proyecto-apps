package com.example.interfaces_pr.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.interfaces_pr.R
import com.example.interfaces_pr.model.Teacher
import com.example.interfaces_pr.viewholders.TeacherViewHolder

class TeacherAdapter(courseType:String): Adapter<TeacherViewHolder>() {

    private var teachers : ArrayList<Teacher> = arrayListOf()

    init{
        if(courseType == "Basketball") {
            teachers.add(Teacher(R.drawable.basketball_course_image,R.drawable.profile1,"Stephen Curry","Descripcion del profesor aqui"))
            teachers.add(Teacher(R.drawable.basketball_course_image,R.drawable.profile2,"Stephen Curry 2","Descripcion del profesor aqui 2"))
        }else if(courseType == "Soccer"){
            teachers.add(Teacher(R.drawable.football_course_image,R.drawable.profile1,"Stephen Curry","Descripcion del profesor aqui"))
            teachers.add(Teacher(R.drawable.football_course_image,R.drawable.profile2,"Stephen Curry2","Descripcion del profesor aqui2"))

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view:View = layoutInflater.inflate(R.layout.teacher,parent,false)
        return TeacherViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        holder.backImg.setImageResource(teachers[position].backgroundImage)
        holder.profileImg.setImageResource(teachers[position].profileImage)
        holder.teacherName.text = teachers[position].teacherName
        holder.teacherDesc.text = teachers[position].teacherInfo
    }

    override fun getItemCount(): Int {
        return teachers.size
    }

}