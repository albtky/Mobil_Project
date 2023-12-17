package com.alperen.myapplication

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.userProfileChangeRequest
import kotlin.coroutines.coroutineContext


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


    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    private var itemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }
    override fun onBindViewHolder(holder: UsersVH, position: Int) {
        val currentUser = UserList[position]

        holder.itemView.findViewById<TextView>(R.id.nameSurname).text= currentUser.regNamesurname
        holder.itemView.findViewById<TextView>(R.id.Job).text=currentUser.regJob
        holder.itemView.findViewById<TextView>(R.id.age).text=currentUser.regAge

        holder.itemView.setOnClickListener {
            itemClickListener?.onItemClick(position)
        }
        }

    }

