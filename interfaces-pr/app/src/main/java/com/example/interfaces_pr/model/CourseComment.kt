package com.example.interfaces_pr.model

import java.io.Serializable

data class CourseComment (
    var userPicture_inComment:Int=0,
    var like_inComment:Int=0,
    var userName_inComment:String="",
    var userCont_inComment:String="",
    var time_inComment:String="",
    var numberLike_inComment:String="",
    var userID:String="",
    var usersLikes:ArrayList<String> = ArrayList(),
    var commentID:String=""
): Serializable {
    fun addOrDelUserLike(userID: String,action:Boolean) {
        if(action){
            usersLikes.add(userID)
        }else{
            usersLikes.remove(userID)
        }

    }

    fun comprobateUserExist(userID: String):Boolean{
        if(usersLikes.contains(userID)){
            return true
        }
        return false
    }

}

