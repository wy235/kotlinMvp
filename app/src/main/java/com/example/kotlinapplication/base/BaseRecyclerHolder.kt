package com.example.kotlinapplication.base

import android.util.SparseArray
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class BaseRecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var mViews: SparseArray<View> = SparseArray()

    fun getItemView(): View {
        return itemView
    }

    private fun <T : View> findViewById(viewId: Int): T {
        var view: View? = mViews.get(viewId)
        if (view == null) {
            view = itemView.findViewById(viewId)
            mViews.put(viewId, view)
        }
        return (view as T?)!!
    }

    fun getView(viewId: Int): View {
        return findViewById(viewId)
    }

    fun getTextView(viewId: Int): TextView {
        return getView(viewId) as TextView
    }

    fun getButton(viewId: Int): Button {
        return getView(viewId) as Button
    }

    fun getImageView(viewId: Int): ImageView {
        return getView(viewId) as ImageView
    }

    fun getImageButton(viewId: Int): ImageButton {
        return getView(viewId) as ImageButton
    }

    fun getEditText(viewId: Int): EditText {
        return getView(viewId) as EditText
    }

    fun getRecyclerView(viewId: Int): RecyclerView {
        return getView(viewId) as RecyclerView
    }

    fun getCheckBox(viewId: Int): CheckBox {
        return getView(viewId) as CheckBox
    }

    fun setText(viewId: Int, value: String): BaseRecyclerHolder {
        val view = findViewById<TextView>(viewId)
        view.text = value
        return this
    }

    fun setTextSise(viewId: Int, value: Float): BaseRecyclerHolder {
        val view = findViewById<TextView>(viewId)
        view.textSize = value
        return this
    }

    fun setBackground(viewId: Int, resId: Int): BaseRecyclerHolder {
        val view = findViewById<View>(viewId)
        view.setBackgroundResource(resId)
        return this
    }

    fun setClickListener(viewId: Int, listener: View.OnClickListener): BaseRecyclerHolder {
        val view = findViewById<View>(viewId)
        view.setOnClickListener(listener)
        return this
    }
}