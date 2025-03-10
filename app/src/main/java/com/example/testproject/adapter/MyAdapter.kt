package com.example.testproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testproject.R
import com.example.testproject.model.MovieData

class MyAdapter(private  val MovieListItem:List<MovieData>)
    :RecyclerView.Adapter<MyAdapter.MovieViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MovieViewHolder {
     val view=LayoutInflater.from(parent.context).inflate(
         R.layout.movie_item,parent ,false)
        return MovieViewHolder(view)
    }
    class MovieViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val image_Avtar:ImageView=view.findViewById(R.id.imageView)
        val first_Name:TextView=view.findViewById(R.id.firstName)
        val last_Name:TextView=view.findViewById(R.id.lastName)
        val email:TextView=view.findViewById(R.id.email)
    }
    override fun onBindViewHolder(holder: MyAdapter.MovieViewHolder, position: Int) {
      val user=MovieListItem[position]

        holder.first_Name.text=user.first_name
        holder.last_Name.text=user.last_name
        holder.email.text=user.email
        Glide.with(holder.itemView.context).load(user.avatar).into(holder.image_Avtar)

    }

    override fun getItemCount()=MovieListItem.size
}


