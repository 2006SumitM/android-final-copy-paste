package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomAdapter(
    private val context: Context,
    private val names: Array<String>
) : BaseAdapter() {

    override fun getCount(): Int = names.size

    override fun getItem(position: Int): String =
        names[position]

    override fun getItemId(position: Int): Long =
        position.toLong()

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val view =
            convertView ?: LayoutInflater.from(context)
                .inflate(
                    R.layout.grid_item,
                    parent,
                    false
                )

        view.findViewById<TextView>(R.id.tvName).text =
            names[position]

        return view
    }
}
