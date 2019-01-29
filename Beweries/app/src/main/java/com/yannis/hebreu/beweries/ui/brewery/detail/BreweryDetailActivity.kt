package com.yannis.hebreu.beweries.ui.brewery.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseAdapter
import com.yannis.hebreu.beweries.R
import com.yannis.hebreu.beweries.ui.Base.BaseActivity
import org.koin.android.ext.android.inject

class BreweryDetailActivity : BaseActivity<DetailBreweryViewModel,com.yannis.hebreu.beweries.databinding.ActivityBreweryDetailBinding>(){

    override val layout: Int = R.layout.activity_brewery_detail

    override val viewModel: DetailBreweryViewModel  by inject()

    override fun initView(savedInstanceState: Bundle?) {
        viewModel.breweryId.value = intent.getIntExtra("id", 0)
        setupToolbar()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
