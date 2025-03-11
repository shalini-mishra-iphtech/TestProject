package com.example.testproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.model.Post

class PostAdapter (private val PostList:List<Post>):RecyclerView.Adapter<PostAdapter.PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.PostViewHolder, position: Int) {
      val post=PostList[position]
        holder.userId.text= "UserId: ${post.userId.toString()}"
        holder.ID.text= "Id: ${post.id.toString()}"
        holder.Title.text="Title: ${post.title}"
        holder.Body.text="Body: ${post.body}"
        holder.Body.maxLines=1
        holder.Body.ellipsize=android.text.TextUtils.TruncateAt.END


    }

    class PostViewHolder(view: View) :RecyclerView.ViewHolder(view){
        var userId:TextView=view.findViewById(R.id.user_Id)
        var ID:TextView=view.findViewById((R.id.id))
        var Title:TextView=view.findViewById(R.id.title)
        var Body:TextView=view.findViewById(R.id.body)

    }

    override fun getItemCount(): Int = PostList.size


}