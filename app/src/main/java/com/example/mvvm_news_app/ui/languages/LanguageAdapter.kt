package com.example.mvvm_news_app.ui.languages

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_news_app.data.model.Language
import com.example.mvvm_news_app.databinding.CountriesItemLayoutBinding

class LanguageAdapter(
    private val languageList: ArrayList<Language>
) : RecyclerView.Adapter<LanguageAdapter.DataViewHolder>() {

    class DataViewHolder(private val binding: CountriesItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(language: Language) {
            binding.textViewTitle.text = language.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            CountriesItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = languageList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(languageList[position])

    fun addData(list: List<Language>) {
        languageList.addAll(list)
    }

}
