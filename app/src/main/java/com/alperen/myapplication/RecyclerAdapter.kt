package com.alperen.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(val UserList: ArrayList<UserInfo>) :

    RecyclerView.Adapter<RecyclerAdapter.UsersVH>() {

    class UsersVH( itemView: View) : RecyclerView.ViewHolder(itemView) {

    }


    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): UsersVH {

        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.cardesign, parent, false)
        return UsersVH(itemView)
    }

    override fun getItemCount(): Int {
        return UserList.size
    }

    override fun onBindViewHolder(holder: UsersVH, position: Int) {
        val currentUser = UserList[position]

        holder.itemView.findViewById<TextView>(R.id.nameSurname).text= currentUser.regNamesurname
        holder.itemView.findViewById<TextView>(R.id.Job).text=currentUser.regJob
        holder.itemView.findViewById<TextView>(R.id.age).text=currentUser.regAge
    }

}
