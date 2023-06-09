package com.example.interfaces_pr.model

import java.io.Serializable

data class User(
    var id:String = "",
    var codeUsuario: String = "",
    var email:String = "",
    var username:String = "",
    val userImg:Int = 0,
    var telefono:String = "",
    var description:String = "",
    var fecha:String = ""


    ) : Serializable{
        override fun toString(): String{
            return codeUsuario
        }
    }
