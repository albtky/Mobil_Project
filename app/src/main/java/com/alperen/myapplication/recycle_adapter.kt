package com.alperen.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.alperen.myapplication.databinding.ActivityHomePageBinding
import org.w3c.dom.Text
import java.util.List;


class recycle_adapter(val UserList: ArrayList<View>) :
    RecyclerView.Adapter<recycle_adapter.UsersVH>() {

    class UsersVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersVH {
        // Inflater, LayotuInflater, MenuInflater gibi
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.cardesign, parent, false)
        return UsersVH(itemView)
    }

    override fun getItemCount(): Int {
        return UserList.size
    }

    override fun onBindViewHolder(holder: UsersVH, position: Int) {
        var name = holder.itemView.findViewById<TextView>(R.id.nameSurname)
        name.text = "alperen tokay"
        var card: CardView = holder.itemView.findViewById<CardView>(R.id.card)


    }
}
