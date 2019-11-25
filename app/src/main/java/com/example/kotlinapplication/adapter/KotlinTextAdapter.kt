package com.example.kotlinapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.alibaba.android.vlayout.DelegateAdapter
import com.alibaba.android.vlayout.LayoutHelper
import com.example.kotlinapplication.R
import com.example.kotlinapplication.base.BaseRecyclerHolder
import java.util.ArrayList

class KotlinTextAdapter(): DelegateAdapter.Adapter<BaseRecyclerHolder>() {

    var mItems: ArrayList<String>? = null
    var mContext:Context? = null
    var mLayoutHelper:LayoutHelper? = null
    var mInflater:LayoutInflater? = null

    constructor(ctx: Context, list: ArrayList<String>, mLayoutHelper: LayoutHelper) : this() {
        this.mItems = list
        this.mContext = ctx
        this.mLayoutHelper = mLayoutHelper
        mInflater = LayoutInflater.from(ctx)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerHolder {
        var holder: BaseRecyclerHolder?
        holder = BaseRecyclerHolder(
            LayoutInflater.from(mContext).inflate(
                R.layout.item_str_layout,
                parent,
                false
            )
        )
        return holder!!
    }

    override fun getItemCount(): Int {
        return mItems!!.size
    }

    override fun onCreateLayoutHelper(): LayoutHelper {
        return this!!.mLayoutHelper!!
    }

    override fun onBindViewHolder(holder: BaseRecyclerHolder, position: Int) {
        var mItemView:TextView = holder.getTextView(R.id.mItemView)
        mItemView.setText(mItems?.get(position))
    }
}
