package com.yannis.hebreu.beweries.utils

import com.yannis.hebreu.beweries.data.model.BaseObject

interface OnItemClickListener<T: BaseObject> {

    fun onItemClick(item: T)

    fun onItemLongClick(item: T): Boolean

}