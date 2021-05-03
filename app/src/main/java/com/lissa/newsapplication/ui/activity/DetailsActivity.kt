package com.lissa.newsapplication.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import com.lissa.newsapplication.R
import com.lissa.newsapplication.databinding.ActivityDetailsBinding
import com.lissa.newsapplication.helpers.Utils
import com.lissa.newsapplication.helpers.observeInLifecycle
import com.lissa.newsapplication.networking.NetworkResponseFilter
import com.lissa.newsapplication.viewModel.ArticlesDetailsViewmodel
import kotlinx.coroutines.flow.onEach

class DetailsActivity : AppCompatActivity() {
    var articlesId: String? = null
    var title: String? = null
    private val viewModel by viewModels<ArticlesDetailsViewmodel>()
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_details)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        getData()
        setActionbar(title)
        initObserable()
    }

    private fun getData() {
        articlesId = intent.getStringExtra(getString(R.string.articlesId))
        title = intent.getStringExtra(getString(R.string.title))
        viewModel.getDetailsScreen(articlesId)
    }

    private fun setActionbar(title: String?) {
        val actionBar: ActionBar? = supportActionBar
        actionBar!!.title = title
        actionBar!!.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

    }

    private fun initObserable() {
        viewModel.uiState.onEach {

            NetworkResponseFilter.getResponse(it, { response ->

                binding.newsDetailsVm = response
                binding.progressbarDetails.visibility = View.GONE
                binding.tvDate.text = Utils.convertISOTimeToDate(response.publishedAt)
            }, { error ->
                binding.progressbarDetails.visibility = View.GONE

            }, {
                binding.progressbarDetails.visibility = View.VISIBLE
            })
        }.observeInLifecycle(binding.lifecycleOwner!!)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }

        return true
    }

}