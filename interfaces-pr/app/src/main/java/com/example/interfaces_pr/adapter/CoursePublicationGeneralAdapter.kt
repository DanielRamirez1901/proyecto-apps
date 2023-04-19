package com.example.interfaces_pr.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.interfaces_pr.R
import com.example.interfaces_pr.model.CoursePublicationGeneral
import com.example.interfaces_pr.viewholders.CoursePublicationGeneralViewHolder
import java.util.*
import kotlin.collections.ArrayList


class CoursePublicationGeneralAdapter():Adapter<CoursePublicationGeneralViewHolder>() {

    private var generalPublications:ArrayList<CoursePublicationGeneral> = arrayListOf()
    var listener: OnItemClickListener? = null


    init{
        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH).toString()
        val month = (calendar.get(Calendar.MONTH) + 1).toString()
        val year = calendar.get(Calendar.YEAR).toString()
        generalPublications.add(CoursePublicationGeneral(R.drawable.profile2,R.drawable.basketball_course_image,"Pepito1",day,month,year,"Esta es una publicacion random que se debe ubicar en los comentarios de la publicacion"))
        generalPublications.add(CoursePublicationGeneral(R.drawable.profile1,R.drawable.football_course_image,"Pepito2",day,month,year,"Esta es una publicacion random que se debe ubicar en los comentarios de la publicacion"))
        generalPublications.add(CoursePublicationGeneral(R.drawable.profile1,R.drawable.basketball_course_image,"Pepito3",day,month,year,"Esta es una publicacion random que se debe ubicar en los comentarios de la publicacion"))

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursePublicationGeneralViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view:View = layoutInflater.inflate(R.layout.course_publication_general,parent,false)
        return CoursePublicationGeneralViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoursePublicationGeneralViewHolder, position: Int) {
        var publications = generalPublications[position]
        holder.pubGeneral_userImg.setImageResource(publications.pubGeneral_userImg)
        holder.pubGeneral_Img.setImageResource(publications.pubGeneral_Img)
        holder.pubGeneral_username.text = publications.pubGeneral_username
        holder.pubGeneral_day.text = publications.pubGeneral_day
        holder.pubGeneral_month.text = publications.pubGeneral_month
        holder.pubGeneral_year.text = publications.pubGeneral_year
        holder.pubGeneral_description.text = publications.pubGeneral_description
        holder.itemView.setOnClickListener{
            listener?.onItemClick(generalPublications[position])
        }

    }

    override fun getItemCount(): Int {
        return generalPublications.size
    }

}