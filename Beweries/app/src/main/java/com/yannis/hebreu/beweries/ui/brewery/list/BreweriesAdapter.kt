package com.yannis.hebreu.beweries.ui.brewery.list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.yannis.hebreu.beweries.R
import com.yannis.hebreu.beweries.data.model.Brewery
import com.yannis.hebreu.beweries.databinding.ItemBreweryBinding
import com.yannis.hebreu.beweries.ui.Base.BaseAdapter
import com.yannis.hebreu.beweries.ui.Base.BaseViewHolder
import com.yannis.hebreu.beweries.utils.OnItemClickListener

class BreweriesAdapter(lifecycleOwner: LifecycleOwner): BaseAdapter<Brewery>(lifecycleOwner) {

    override fun layoutFor(position: Int): Int = R.layout.item_brewery


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Brewery, *> {
        val binding: com.yannis.hebreu.beweries.databinding.ItemBreweryBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false)
        return MovieViewHolder(binding)
    }

    class MovieViewHolder(private val binding: ItemBreweryBinding): BaseViewHolder<Brewery, ItemBreweryBinding>(binding) {

        override fun bind(lifecycleOwner: LifecycleOwner, item: Brewery, listener: OnItemClickListener<Brewery>) {
            super.bind(lifecycleOwner, item, listener)
            binding.title.text = item.name
            binding.updated.text = item.state
        }
    }
}