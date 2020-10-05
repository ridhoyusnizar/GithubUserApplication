package com.example.githubuserapp

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: UserAdapter
    private lateinit var dataAvatar: TypedArray
    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataRepository: IntArray
    private lateinit var dataFollowing: IntArray
    private lateinit var dataFollowers: IntArray
    private var users = arrayListOf<User>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView: ListView = findViewById(R.id.lv_list)
        adapter = UserAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()
        listView.onItemClickListener = AdapterView.OnItemClickListener{
                _,_,position,_->
            val moveIntent = Intent(this,DetailActivity::class.java)
            val selectedUser: User = users[position]
            moveIntent.putExtra(DetailActivity.EXTRA_USER, selectedUser)
            startActivity(moveIntent)
        }

    }

    private fun prepare() {
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getIntArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getIntArray(R.array.followers)
        dataFollowing = resources.getIntArray(R.array.following)
    }

    private fun addItem() {
        for (position in dataUsername.indices) {
            val user = User(
                dataAvatar.getResourceId(position, -1),
                dataUsername[position],
                dataName[position],
                dataLocation[position],
                dataRepository[position],
                dataCompany[position],
                dataFollowers[position],
                dataFollowing[position]
                )
            users.add(user)
        }
        adapter.user = users
    }
}