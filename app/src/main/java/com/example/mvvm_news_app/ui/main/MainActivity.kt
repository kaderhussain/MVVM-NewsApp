package com.example.mvvm_news_app.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvm_news_app.NewsApplication
import com.example.mvvm_news_app.databinding.ActivityMainBinding
import com.example.mvvm_news_app.di.component.DaggerActivityComponent
import com.example.mvvm_news_app.di.module.ActivityModule
import com.example.mvvm_news_app.ui.countries.CountryActivity
import com.example.mvvm_news_app.ui.languages.LanguageActivity
import com.example.mvvm_news_app.ui.news_sources.NewsSourcesActivity
import com.example.mvvm_news_app.ui.search.SearchActivity
import com.example.mvvm_news_app.ui.topheadline.TopHeadlineActivity

class MainActivity : AppCompatActivity() {

    private val Tag = "MainActivity"

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        Log.e(Tag, "Started");
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupUI()
//        setupObserver()
    }

    private fun setupUI() {


        binding.btnTopHeadline.setOnClickListener {
            startActivity(TopHeadlineActivity.getStartIntent(this, "us"))
        }

        binding.btnNewsSources.setOnClickListener {
            startActivity(NewsSourcesActivity.getStartIntent(this))
        }

        binding.btnCountries.setOnClickListener {
            startActivity(CountryActivity.getStartIntent(this))
        }

        binding.btnLanguages.setOnClickListener {
            startActivity(LanguageActivity.getStartIntent(this))
        }

        binding.btnSearch.setOnClickListener {
            startActivity(SearchActivity.getStartIntent(this))
        }
    }

    private fun injectDependencies() {
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as NewsApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
            .injectMain(this)
    }


}
