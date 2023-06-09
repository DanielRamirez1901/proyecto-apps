package com.example.interfaces_pr.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.interfaces_pr.R
import com.example.interfaces_pr.model.CoursePublicationGeneral
import com.example.interfaces_pr.model.CoursePublications
import com.example.interfaces_pr.model.cursoAtri
import com.example.interfaces_pr.viewholders.CoursePublicationViewHolder
import java.util.Calendar

interface OnItemClickListener {
    fun onItemClick(coursePublications: CoursePublications)

    fun onItemClick(coursePublicationsG: CoursePublicationGeneral)

    fun onItemClick(coursePublications: cursoAtri)



}
class CoursePublicationAdapter():Adapter<CoursePublicationViewHolder>() {

    private var publications:ArrayList<CoursePublications> = arrayListOf()
    var listener: OnItemClickListener? = null

    init{
        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH).toString()
        val month = (calendar.get(Calendar.MONTH) + 1).toString()
        val year = calendar.get(Calendar.YEAR).toString()
        publications.add(CoursePublications(R.drawable.profile1,R.drawable.basketball_course_image,"Stephen Kury",day,month,year,"Este es el contenido de la publicacion hecha por mi 1123123123123123"))
        publications.add(CoursePublications(R.drawable.profile2,R.drawable.football_course_image,"Stephen Kury 2",day,month,year,"Este es el contenido de la publicacion hecha por mi 1123123123123123"))
        publications.add(CoursePublications(R.drawable.profile1,R.drawable.basketball_course_image,"Stephen Kury 3",day,month,year,"Este es el contenido de la publicacion hecha por mi 1123123123123123"))
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursePublicationViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view:View = layoutInflater.inflate(R.layout.teacher_publication,parent,false)
        return CoursePublicationViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoursePublicationViewHolder, position: Int) {
        holder.pUser.setImageResource(publications[position].pbUser)
        holder.imagePublic.setImageResource(publications[position].imagePublic)
        holder.userName.text = publications[position].userName
        holder.day.text = publications[position].day
        holder.month.text = publications[position].month
        holder.year.text = publications[position].year
        holder.pbContent.text = publications[position].pbContent
        holder.itemView.setOnClickListener{
            listener?.onItemClick(publications[position])
        }
    }

    override fun getItemCount(): Int {
        return publications.size
    }

}