package com.lissa.newsapplication.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.lissa.newsapplication.OnclickListner
import com.lissa.newsapplication.R
import com.lissa.newsapplication.databinding.ActivityMainBinding
import com.lissa.newsapplication.model.ArticlesItem
import com.lissa.newsapplication.networking.NetworkUiState
import com.lissa.newsapplication.ui.adapter.NewsListAdapter
import com.lissa.newsapplication.viewModel.NewsViewModel
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity(), OnclickListner {
    lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NewsListAdapter
    private val viewModel by viewModels<NewsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setActionBars()
        callApi()
        setupUi()
        initObserver()
    }

    private fun setActionBars() {
        val actionBar: ActionBar? = supportActionBar
        actionBar!!.title = getString(R.string.news)
        actionBar!!.setDisplayHomeAsUpEnabled(false)
    }

    private fun setupUi() {
        binding.rvArticlesList.layoutManager = LinearLayoutManager(this)
        adapter = NewsListAdapter(arrayListOf())
        binding.rvArticlesList.adapter = adapter
        adapter.listner = this
    }

    private fun initObserver() {

        lifecycleScope.launchWhenStarted {
            // Triggers the flow and starts listening for values
            viewModel.uiState.collect { uiState ->
                when (uiState) {
                    is NetworkUiState.Success -> {
                        showNewsList(uiState.news as List<ArticlesItem>)
                        binding.progressCircular.visibility = View.GONE
                    }

                    is NetworkUiState.Error -> {
                        showError(uiState.exception)
                        binding.progressCircular.visibility = View.VISIBLE
                    }
                    is NetworkUiState.Loading -> {
                        binding.progressCircular.visibility = View.VISIBLE
                    }
                }

            }
        }


    }

    private fun showError(exception: Throwable) {
        Log.e("TAG", "showError: " + exception)
    }

    private fun showNewsList(news: List<ArticlesItem>) {


        adapter.apply {
            addNewsList(news)
            notifyDataSetChanged()
        }

    }


    private fun callApi() {
        viewModel.getNewsList()
    }

    override fun getdetails(articles: ArticlesItem) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(getString(R.string.articlesId), articles.id)
        intent.putExtra(getString(R.string.title), articles.title)
        startActivity(intent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}