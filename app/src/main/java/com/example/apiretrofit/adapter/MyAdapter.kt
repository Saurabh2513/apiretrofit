package com.example.apiretrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.example.apiretrofit.Book
import com.example.apiretrofit.R

class MyAdapter(var con : Context, var list: List<Book>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(v:View):RecyclerView.ViewHolder(v){

var img = v.findViewById<ImageView>(R.id.profile_image)
var tvName = v.findViewById<TextView>(R.id.book_title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(con).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view  )
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(con).load(list[position].image).into(holder.img)
        holder.tvName.text = list[position].title

    }

}