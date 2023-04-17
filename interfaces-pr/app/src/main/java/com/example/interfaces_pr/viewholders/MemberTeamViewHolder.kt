package com.example.interfaces_pr.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.interfaces_pr.databinding.TeamIcesiBinding

class MemberTeamViewHolder(root:View):ViewHolder(root) {

    private val binding = TeamIcesiBinding.bind(root)
    val shieldTeam = binding.shieldTeamImg
    val profileTeam = binding.profileTeamImg
    val playerName = binding.playerNameTxt
    val roleTeam = binding.roleTeamTxt

}