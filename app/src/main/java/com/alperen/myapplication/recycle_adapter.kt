package com.alperen.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.alperen.myapplication.databinding.ActivityHomePageBinding
import com.alperen.myapplication.databinding.ActivityRegisterscreenBinding
import org.w3c.dom.Text
import java.util.List;
import kotlin.coroutines.coroutineContext


class recycle_adapter(val UserList: ArrayList<UserInfo>) :

    RecyclerView.Adapter<recycle_adapter.UsersVH>() {

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

        holder.itemView.findViewById<TextView>(R.id.nameSurname).text= currentUser.nameSurname
        holder.itemView.findViewById<TextView>(R.id.Job).text=currentUser.Job
        holder.itemView.findViewById<TextView>(R.id.age).text=currentUser.age
    }

}
