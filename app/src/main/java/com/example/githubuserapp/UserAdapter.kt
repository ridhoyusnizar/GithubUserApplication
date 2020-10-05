package com.example.githubuserapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView
import org.w3c.dom.Text

class UserAdapter internal constructor(private val context: Context): BaseAdapter() {
    internal var user = arrayListOf<User>()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if(itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup,false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemView
    }

    private inner class ViewHolder internal constructor(view:View){
        private val tvUsername: TextView = view.findViewById(R.id.tv_username)
        private val tvLocation : TextView = view.findViewById(R.id.tv_location)
        private val tvCompany : TextView = view.findViewById(R.id.tv_company)
        private val imgAvatar : CircleImageView = view.findViewById(R.id.img_avatar)

        internal fun bind(user:User){
            tvUsername.text = user.name
            tvLocation.text = user.location
            tvCompany.text = user.company
            imgAvatar.setImageResource(user.avatar)
        }
    }

    override fun getItem(position: Int): Any = user[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = user.size
}