package com.example.githubuserapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import de.hdodenhof.circleimageview.CircleImageView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataUser = intent.getParcelableExtra<User>(EXTRA_USER) as User
        val tvUsername: TextView = findViewById(R.id.tv_username)
        val tvName: TextView = findViewById(R.id.tv_name)
        val imgAvatar: CircleImageView = findViewById(R.id.img_avatar)
        val tvRepository: TextView = findViewById(R.id.tv_repository)
        val tvFollowers: TextView = findViewById(R.id.tv_followers)
        val tvFollowing: TextView = findViewById(R.id.tv_following)
        val tvLocation: TextView = findViewById(R.id.tv_location)
        val tvCompany: TextView = findViewById(R.id.tv_company)

        supportActionBar?.title = dataUser.username
        tvUsername.text = dataUser.username
        tvName.text = dataUser.name
        imgAvatar.setImageResource(dataUser.avatar)
        tvRepository.text = dataUser.repository.toString()
        tvFollowers.text = dataUser.followers.toString()
        tvFollowing.text = dataUser.following.toString()
        tvLocation.text = dataUser.location
        tvCompany.text = dataUser.company


    }
}