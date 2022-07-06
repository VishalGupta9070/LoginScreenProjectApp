package com.example.projectapp.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectapp.R
import com.example.projectapp.roomdata.Details

class AdapterList (val context: Context,private val mlist: ArrayList<Details>) : RecyclerView.Adapter<AdapterList.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val email: TextView = itemView.findViewById(R.id.email)
        val name: TextView = itemView.findViewById(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.listof_details, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val itemsView = mlist[position]

        holder.email.text = itemsView.email
        holder.name.text = itemsView.name
    }

    override fun getItemCount(): Int {
        return mlist.size
    }
    fun updateList(list : List<Details>){
        mlist.clear()
        mlist.addAll(list)
        notifyDataSetChanged()
    }
}