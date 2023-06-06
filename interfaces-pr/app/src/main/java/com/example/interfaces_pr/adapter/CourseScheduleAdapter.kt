package com.example.interfaces_pr.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.interfaces_pr.R
import com.example.interfaces_pr.model.CourseSchedule
import com.example.interfaces_pr.viewholders.CourseScheduleViewHolder

class CourseScheduleAdapter() : Adapter<CourseScheduleViewHolder>() {

    private var courseSchedule : ArrayList<CourseSchedule> = arrayListOf()


    init{
            courseSchedule.add(CourseSchedule("5:00 pm", "7:00 pm", "Martes", "Stephen Curry"))
            courseSchedule.add(CourseSchedule("5:00 pm", "7:00 pm", "Martes", "Stephen Curry"))
            courseSchedule.add(CourseSchedule("5:00 pm", "7:00 pm", "Martes", "Stephen Curry"))
            courseSchedule.add(CourseSchedule("5:00 pm", "7:00 pm", "Martes", "Stephen Curry"))
    }

    //Crea los esqueletos de los items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseScheduleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.course_schedule, parent, false)
        return CourseScheduleViewHolder(view)
    }

    //Poner datos en el esqueleto
    override fun onBindViewHolder(holder: CourseScheduleViewHolder, position: Int) {
        holder.hour1.text = courseSchedule[position].hour1
        holder.hour2.text = courseSchedule[position].hour2
        holder.day.text = courseSchedule[position].day
        holder.teacher.text = courseSchedule[position].teacherName
    }

    override fun getItemCount(): Int {
        return courseSchedule.size
    }

}