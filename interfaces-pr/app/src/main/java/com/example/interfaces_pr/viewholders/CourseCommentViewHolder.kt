package com.example.interfaces_pr.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.interfaces_pr.databinding.CommentStyleBinding

class CourseCommentViewHolder(root:View):ViewHolder(root) {

    private val binding = CommentStyleBinding.bind(root)
    val user_inComment = binding.userIncommentImg
    val like_inComment = binding.likeIncommentImg
    val userName_inComment = binding.usernameIncommentTxt
    val userCont_inComment = binding.usercontIncommentTxt
    val time_inComment = binding.timeIncommentTxt
    val numberLike_inComment = binding.numerLikesIncommentTxt
}