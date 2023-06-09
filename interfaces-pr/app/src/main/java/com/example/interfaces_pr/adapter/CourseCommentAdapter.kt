package com.example.interfaces_pr.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.interfaces_pr.R
import com.example.interfaces_pr.model.CourseComment
import com.example.interfaces_pr.model.User
import com.example.interfaces_pr.viewholders.CourseCommentViewHolder
import com.google.gson.Gson
import com.google.gson.JsonObject

interface OnItemButtonListener {
    fun onCommentButtonClick(commentHolder: CourseCommentViewHolder,commentObject:CourseComment)
}

class CourseCommentAdapter():Adapter<CourseCommentViewHolder>() {

    var comments:ArrayList<CourseComment> = arrayListOf()
    var commentButtonClickListener: OnItemButtonListener? = null


    /*
    init{
        val timestamp = 1648822800000 // Ejemplo de marca de tiempo en milisegundos (30 de marzo de 2022, 1:00 PM hora local)
        val minutesElapsed = getMinutesElapsedFromTimestamp(timestamp).toString()
        comments.add(CourseComment(R.drawable.profile1,R.drawable.unlike_icon,"Pepito",commentInPub,minutesElapsed,"1"))
    }

     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseCommentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view:View = layoutInflater.inflate(R.layout.comment_style,parent,false)
        val viewHolder = CourseCommentViewHolder(view)
        viewHolder.comentarBtn.setOnClickListener {
            viewHolder.setVisibility(true)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: CourseCommentViewHolder, position: Int) {
        holder.user_inComment.setImageResource(comments[position].userPicture_inComment)
        holder.userName_inComment.text = comments[position].userName_inComment
        holder.userCont_inComment.text = comments[position].userCont_inComment
        holder.time_inComment.text = comments[position].time_inComment
        holder.numberLike_inComment.text = comments[position].usersLikes.size.toString()
        if(comments[position].comprobateUserExist(comments[position].userID)){
            holder.like_inComment.setImageResource(R.drawable.like_icon)
        }else{
            holder.like_inComment.setImageResource(R.drawable.unlike_icon)
        }
        holder.like_inComment.setOnClickListener {
            Log.d(">>>", "Llego hasta onBind")
            commentButtonClickListener?.onCommentButtonClick(holder,comments[position])
        }
        holder.setVisibility(false)
    }





    override fun getItemCount(): Int {
        return comments.size
    }

    fun addComment(comment: CourseComment) {
        comments.add(0, comment)
        notifyItemInserted(0)
        notifyDataSetChanged()

    }



}