package com.example.interfaces_pr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.interfaces_pr.databinding.ActivityPublicationsBinding

class PublicationsActivity : AppCompatActivity() {

    private var numLikes = 0
    private var isLiked = false

    private val binding by lazy{
        ActivityPublicationsBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val publicationTitle:String? = intent.extras?.getString("publicationTitle")
        val publicationCont:String? = intent.extras?.getString("publicationCont")
        val userImg:Int? = intent.extras?.getInt("userImg")
        val publicationImg:Int? = intent.extras?.getInt("publicationImg")

        binding.publicationTitleTxt.text = publicationTitle
        binding.publicationContTxt.text = publicationCont
        userImg?.let {
            binding.userImg.setImageResource(userImg)
        }
        publicationImg?.let {
            binding.publicationImg.setImageResource(publicationImg)
        }

        binding.backButton.setOnClickListener{
            val intent = Intent(this,CourseActivity::class.java)
            startActivity(intent)
        }

        binding.likeImg.setOnClickListener{
            if(isLiked){
                numLikes --
                binding.likeImg.setImageResource(R.drawable.unlike_icon)
                binding.reactionsTxt.text = numLikes.toString()
                isLiked = false
            }else{
                numLikes++
                binding.likeImg.setImageResource(R.drawable.like_icon)
                binding.reactionsTxt.text = numLikes.toString()
                isLiked = true
            }
        }
    }
}