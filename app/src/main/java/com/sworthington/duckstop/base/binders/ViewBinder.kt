package com.sworthington.duckstop.base.binders

import android.view.ViewGroup

//TODO - delete this and ViewBinders on the off chance there's no RecyclerView in project
internal interface ViewBinder<T, A> {
    fun bind(data: T, holder: A)
    fun onCreateViewHolder(parent:ViewGroup, viewType: Int): A
}