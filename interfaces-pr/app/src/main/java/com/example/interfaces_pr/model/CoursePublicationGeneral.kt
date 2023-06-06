package com.example.interfaces_pr.model

import java.io.Serializable

data class CoursePublicationGeneral (
    val pubGeneral_userImg:Int=0,
    val pubGeneral_Img:Int=0,
    val pubGeneral_username:String="",
    val pubGeneral_day:String="",
    val pubGeneral_month:String="",
    val pubGeneral_year:String="",
    val pubGeneral_description:String="",
    val courseName:String="",
    val userID:String="",

) : Serializable{
    override fun toString(): String {
        return pubGeneral_username
    }
}