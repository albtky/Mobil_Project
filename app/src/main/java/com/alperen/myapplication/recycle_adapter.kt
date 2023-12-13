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


class recycle_adapter(regbinding: registerscreen, val UserList: ArrayList<View>) :

    RecyclerView.Adapter<recycle_adapter.UsersVH>() {

    class UsersVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

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
        val inflater= LayoutInflater.from(holder.itemView.context)
        val regsiterview=inflater.inflate(R.layout.activity_registerscreen,null)
        val regName = regsiterview.findViewById<TextView>(R.id.regName)
        val regAge = regsiterview.findViewById<TextView>(R.id.regAge)
        val regJob = regsiterview.findViewById<TextView>(R.id.regJob)

        var name = holder.itemView.findViewById<TextView>(R.id.nameSurname)
        name.text = regName.text.toString()
        var age = holder.itemView.findViewById<TextView>(R.id.age)
        age.text=regAge.text.toString()
        var job = holder.itemView.findViewById<TextView>(R.id.Job)
        job.text=regJob.text.toString()

        var Card:CardView= holder.itemView.findViewById<CardView>(R.id.card)



    }
}
