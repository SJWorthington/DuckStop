package com.sworthington.baseapplication.base.binders

import android.view.ViewGroup

internal class ViewBinders<T, A>(defaultBinder: ViewBinder<T, A>) {

    private val binders = mutableMapOf<Int, ViewBinder<T, A>>().withDefault { defaultBinder }

    fun addBinder(typeId: Int, binder: ViewBinder<T, A>) {
        binders[typeId] = binder
    }

    fun bind(data: T, typeId: Int, holder: A) = resolveBinderOrDefault(typeId).bind(data, holder)

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = resolveBinderOrDefault(viewType).onCreateViewHolder(parent, viewType)

    private fun resolveBinderOrDefault(viewType: Int) = binders.getValue(viewType)
}