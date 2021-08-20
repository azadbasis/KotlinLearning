package com.azharul.kotlinlearning.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azharul.kotlinlearning.R
import com.azharul.kotlinlearning.model.Post
import kotlinx.android.synthetic.main.post_item_cell.view.*

class PostRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var posts: List<Post> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
      return PostViewHolder(
          LayoutInflater.from(parent.context).inflate(R.layout.post_item_cell,parent,false)
      )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
     when(holder){
         is PostViewHolder->{
             holder.bind(posts.get(position))
         }
     }
    }

    override fun getItemCount(): Int {
        return posts.size
    }
fun submitPostData(postList:List<Post>){
    posts=postList
    notifyDataSetChanged()
}
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userId: TextView = itemView.textView
        val title: TextView = itemView.textView2
        val body: TextView = itemView.textView3
        fun bind(post:Post){
            userId.text=post.userId.toString()
            title.text=post.title
            body.text=post.body
        }
    }


}