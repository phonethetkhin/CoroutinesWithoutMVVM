package com.example.coroutineswithoutmvvm

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(val postmodelList:List<PostModel>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v)
    {
        val userID=v.findViewById<TextView>(R.id.tvUserID)
        val ID=v.findViewById<TextView>(R.id.tvID)
        val Title=v.findViewById<TextView>(R.id.tvTitle)
        val Body=v.findViewById<TextView>(R.id.tvBody)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.postlistitem,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
return postmodelList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
  holder.userID.text=postmodelList[position].userId.toString()
  holder.ID.text=postmodelList[position].id.toString()
  holder.Title.text=postmodelList[position].title
  holder.Body.text=postmodelList[position].body
    }

}