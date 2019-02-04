package com.yannis.hebreu.beweries.ui.brewery.list


import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.yannis.hebreu.beweries.R
import com.yannis.hebreu.beweries.data.model.Brewery
import com.yannis.hebreu.beweries.data.remote.BreweryResponseCallback
import com.yannis.hebreu.beweries.databinding.ActivityMainBinding
import com.yannis.hebreu.beweries.extension.showAction
import com.yannis.hebreu.beweries.extension.showError
import com.yannis.hebreu.beweries.extension.startAnimatedActivity
import com.yannis.hebreu.beweries.ui.base.BaseActivity
import com.yannis.hebreu.beweries.ui.brewery.detail.BreweryDetailActivity
import org.jetbrains.anko.alert
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.noButton
import org.jetbrains.anko.yesButton
import org.koin.androidx.viewmodel.ext.android.viewModel

class BreweriesActivity : BaseActivity<BreweriesViewModel,ActivityMainBinding>()  {


    override val layout: Int = R.layout.activity_main

    override val viewModel: BreweriesViewModel by viewModel()

    private val breweriesAdapter = BreweriesAdapter(this)

    override fun initView(savedInstanceState: Bundle?) {
        setupAdapter()
        setupRecyclerView()
        setupSwipeRefreshLayout()
    }

    private fun setupAdapter() {
        viewModel.breweries.observe(this, Observer {
            breweriesAdapter.submitList(it)
        })

        breweriesAdapter.apply {
            onClick = { startAnimatedActivity(intentFor<BreweryDetailActivity>("id" to it.id)) }
            onLongClick = { showDeletePopup(it) }
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            addItemDecoration(DividerItemDecoration(this@BreweriesActivity, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(this@BreweriesActivity)
            adapter = breweriesAdapter
        }
    }

    private fun setupSwipeRefreshLayout() {
        binding.swipeRefreshLayout.apply {

            fun refresh() {
                isRefreshing = true
                viewModel.refresh(object: BreweryResponseCallback {
                    override fun onSuccess() {
                        binding.root.showAction(getString(R.string.breweries_loaded))
                        isRefreshing = false
                    }

                    override fun onError(throwable: Throwable) {
                        binding.root.showError(getString(R.string.breweries_loading_error))
                        isRefreshing = false
                    }
                })
            }

            setOnRefreshListener { refresh() }
            post { refresh() }
        }
    }

    private fun showDeletePopup(brewery: Brewery) {
        alert(getString(R.string.delete_brewery_warning, brewery.name)) {
            yesButton { viewModel.delete(brewery) }
            noButton { }
        }.show()
    }

}
