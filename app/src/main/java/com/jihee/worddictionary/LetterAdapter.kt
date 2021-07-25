package com.jihee.worddictionary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class LetterAdapter : RecyclerView.Adapter<LetterAdapter.ViewHolder>() {
    private val list = ('A').rangeTo('Z').toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
            //also : return값이 뷰 자체 (apply와 비슷/하지만 apply는 객체의 속성을 다룰때 사용)
        ).also {
            it.button.setOnClickListener {

            }
        }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
//        val viewHolder = ViewHolder(view)
//        viewHolder.button.setOnClickListener {
//
//        }
//        return viewHolder
//    }

    //viewHolder가 노출됐을때 아이템이랑 연결해서 보여줌?
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val letter = list[position]
//        holder.button.text = letter.toString()

        holder.apply {
            button.text = list[position].toString()
        }
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.btn_item)
    }
}

