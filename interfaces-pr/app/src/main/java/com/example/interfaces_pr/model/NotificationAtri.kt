package com.example.interfaces_pr.model

import java.io.Serializable

data class NotificationAtri(
    val userImg:Int = 0,
    val courseType:String = "",
    val courseName:String = "",
    val publicationImg:Int = 0,
    val userName:String = "",
    val typeActivity:String = "",
    val userID:String = "",
    val publicationID:String = ""
):Serializable{

}
