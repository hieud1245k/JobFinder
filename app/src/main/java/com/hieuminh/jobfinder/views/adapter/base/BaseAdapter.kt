package com.hieuminh.jobfinder.views.adapter.base

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseAdapter<T>.BaseViewHolder>() {
    protected var dataList: MutableList<T> = ArrayList()
    internal var itemEventListener: ItemEventListener<T>? = null

    @SuppressLint("NotifyDataSetChanged")
    open fun updateData(list: MutableList<T>?, isReload: Boolean = true) {
        list?.let {
            dataList = it
            if (isReload) {
                this.notifyDataSetChanged()
            }
        }
    }

    fun setItemListener(itemEventListener: ItemEventListener<T>?) {
        this.itemEventListener = itemEventListener
    }

    fun dataListRemoveAt(position: Int) {
        dataList.removeAt(position)
        this.notifyItemRemoved(position)
    }

    fun isEmptyData(): Boolean {
        return dataList.isEmpty()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    abstract inner class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                itemEventListener?.onItemClick(dataList[layoutPosition], layoutPosition)
            }
        }

        abstract fun bind(data: T)
    }

    inner class EmptyViewHolder(itemView: View) : BaseViewHolder(itemView) {
        override fun bind(data: T) = Unit
    }

    interface ItemEventListener<T> {
        fun onItemClick(item: T, position: Int)
    }
}
