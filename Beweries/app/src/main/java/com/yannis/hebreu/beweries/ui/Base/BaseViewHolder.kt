package com.yannis.hebreu.beweries.ui.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.yannis.hebreu.beweries.BR
import com.yannis.hebreu.beweries.data.model.BaseObject
import com.yannis.hebreu.beweries.utils.OnItemClickListener

abstract class BaseViewHolder<T: BaseObject, V: ViewDataBinding>(private val viewDataBinding: V): RecyclerView.ViewHolder(viewDataBinding.root) {

    protected lateinit var item: T

    open fun bind(lifecycleOwner: LifecycleOwner, item: T, listener: OnItemClickListener<T>) {
        this.item = item
        //binding item_brewery.xml
        viewDataBinding.setLifecycleOwner(lifecycleOwner)
        viewDataBinding.setVariable(BR.item, item)
        viewDataBinding.setVariable(BR.listener, listener)
        viewDataBinding.executePendingBindings()
    }
}