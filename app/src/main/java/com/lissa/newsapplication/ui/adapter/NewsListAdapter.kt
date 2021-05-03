package com.lissa.newsapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lissa.newsapplication.OnclickListner
import com.lissa.newsapplication.R
import com.lissa.newsapplication.model.ArticlesItem


class NewsListAdapter(private val users: ArrayList<ArticlesItem>) :
    RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {
    lateinit var listner: OnclickListner

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_post: TextView = itemView.findViewById(R.id.tv_post)
        val tv_description: TextView = itemView.findViewById(R.id.tv_description)
        val iv_image: ImageView = itemView.findViewById(R.id.iv_image)
        fun bind(articles: ArticlesItem) {
            itemView.apply {
                tv_post.text = articles.title
                tv_description.text = articles.summary

                Glide.with(iv_image.context)
                    .load(articles.imageUrl)
                    .into(iv_image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.component_news_list_item, parent, false)
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val articles = users[position]
        holder.bind(articles)

        holder.itemView.setOnClickListener {
            if (::listner.isInitialized){
                listner.getdetails(articles)
            }

        }
    }

    fun addNewsList(users: List<ArticlesItem>) {
        this.users.apply {
            clear()
            addAll(users)
        }

    }
}