package com.example.interfaces_pr.viewholders

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.interfaces_pr.databinding.CommentStyleBinding
import android.view.ViewGroup.LayoutParams
import androidx.appcompat.app.AppCompatActivity
import com.example.interfaces_pr.R
import com.example.interfaces_pr.model.User
import com.google.gson.Gson


class CourseCommentViewHolder(private val root:View):ViewHolder(root) {

    private val binding = CommentStyleBinding.bind(root)
    val user_inComment = binding.userIncommentImg
    val like_inComment = binding.likeIncommentImg
    val userName_inComment = binding.usernameIncommentTxt
    val userCont_inComment = binding.usercontIncommentTxt
    val time_inComment = binding.timeIncommentTxt
    val numberLike_inComment = binding.numerLikesIncommentTxt
    val comentarBtn = binding.comentarBtn
    val actualUserImg = binding.actualUserImg
    val fieldToComment = binding.fieldToCommentTxt
    val sendBtnComment = binding.sendCommentBtn



    fun setVisibility(isVisible: Boolean) {
        var visibility: Int
        if (isVisible) {
            visibility = View.VISIBLE
            setResourcesInComment()
        } else {
            visibility = View.GONE
        }

        actualUserImg.visibility = visibility
        fieldToComment.visibility = visibility
        sendBtnComment.visibility = visibility

        /*
        if(isVisible){
            containerGeneral.layoutParams.height = LayoutParams.WRAP_CONTENT
        }else{
            val layoutParams = containerGeneral.layoutParams as LayoutParams
            layoutParams.height = limit.top
            containerGeneral.layoutParams = layoutParams
        }

         */


    }

    private fun setResourcesInComment(){
        actualUserImg.setImageResource(R.drawable.profile1)
    }
    private fun getUser(): User? {
        val context = root.context
        val sp = context.getSharedPreferences("CampusBu", Context.MODE_PRIVATE)
        val json = sp.getString("user", null)
        return if (json != null) {
            Gson().fromJson(json, User::class.java)
        } else {
            null
        }
    }


}