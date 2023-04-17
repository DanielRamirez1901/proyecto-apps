package com.example.interfaces_pr.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.interfaces_pr.R
import com.example.interfaces_pr.model.MemberTeam
import com.example.interfaces_pr.viewholders.MemberTeamViewHolder

class MemberTeamAdapter(courseType:String):Adapter<MemberTeamViewHolder>() {


    private var membersTeam :ArrayList<MemberTeam> = arrayListOf()

    init{
        if(courseType == "Basketball"){
            membersTeam.add(MemberTeam(R.drawable.escudo_basket,R.drawable.player1,"Stephen Curry","Capitan"))
            membersTeam.add(MemberTeam(R.drawable.escudo_basket,R.drawable.player2,"Stephen Curry","Capitan"))
            membersTeam.add(MemberTeam(R.drawable.escudo_basket,R.drawable.player3,"Stephen Curry","Capitan"))
        }else if(courseType == "Soccer"){
            membersTeam.add(MemberTeam(R.drawable.escudo_basket,R.drawable.player1,"Stephen Curry","Capitan"))
            membersTeam.add(MemberTeam(R.drawable.escudo_basket,R.drawable.player2,"Stephen Curry","Capitan"))
            membersTeam.add(MemberTeam(R.drawable.escudo_basket,R.drawable.player3,"Stephen Curry","Capitan"))

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberTeamViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view:View = layoutInflater.inflate(R.layout.team_icesi,parent,false)
        return MemberTeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemberTeamViewHolder, position: Int) {
        holder.shieldTeam.setImageResource(membersTeam[position].shieldTeam)
        holder.profileTeam.setImageResource(membersTeam[position].profileTeam)
        holder.playerName.text = membersTeam[position].playerName
        holder.roleTeam.text = membersTeam[position].roleTeam
    }

    override fun getItemCount(): Int {
        return membersTeam.size
    }


}