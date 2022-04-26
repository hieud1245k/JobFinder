package com.hieuminh.jobfinder.views.adapter.base

import android.annotation.SuppressLint
import android.widget.Filter
import android.widget.Filterable

abstract class BaseFilterAdapter<T>: BaseAdapter<T>(), Filterable {
    private var originList: MutableList<T> = ArrayList()
    private var filterCondition: ((T, String) -> Boolean)? = null

    override fun updateData(list: MutableList<T>?, isReload: Boolean) {
        list?.let {
            originList = list
            super.updateData(list, isReload)
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val searchText = p0?.toString() ?: ""
                val filteredList = if (searchText.isEmpty()) {
                    originList
                } else {
                    originList.filter { item -> filterCondition?.invoke(item, searchText) == true}
                }
                return FilterResults().apply {
                    values = filteredList
                }
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                try {
                    if (p1?.values is MutableList<*>) {
                        dataList = (p1.values as MutableList<T>) // TODO (Hieu Minh): update later
                        notifyDataSetChanged()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    fun setFilterCondition(filterCondition: ((T, String) -> Boolean)?) {
        this.filterCondition = filterCondition
    }
}
