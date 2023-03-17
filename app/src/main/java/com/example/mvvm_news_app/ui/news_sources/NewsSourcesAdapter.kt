package com.example.mvvm_news_app.ui.news_sources

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_news_app.data.model.NewsSources
import com.example.mvvm_news_app.databinding.NewsSourcesItemLayoutBinding

class NewsSourcesAdapter(
    private val newSourceList: ArrayList<NewsSources>
) : RecyclerView.Adapter<NewsSourcesAdapter.DataViewHolder>() {

    class DataViewHolder(private val binding: NewsSourcesItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: NewsSources) {
            binding.textViewTitle.text = article.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            NewsSourcesItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = newSourceList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(newSourceList[position])

    fun addData(list: List<NewsSources>) {
        newSourceList.addAll(list)
    }

}
