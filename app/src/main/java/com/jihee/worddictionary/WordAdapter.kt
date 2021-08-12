package com.jihee.worddictionary

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView


/**
 * @param letterId : 그 단어로 시작하는 리스트를 받아오기 위해
 * @param context : getStringArray 사용을 위해
 */
class WordAdapter(private val letterId: String, context: Context) :
    RecyclerView.Adapter<WordAdapter.ViewHolder>() {
    private val filteredWords: List<String> =
        context.resources.getStringArray(R.array.words).toList() //리스트화
            .filter { it.startsWith(letterId, ignoreCase = true) } //대소문자 구분안함
            .shuffled()  //순서 섞고
            .take(5) //5개만 가져와
            .sorted() //알파벳 정렬순

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
    ).also {
        it.button.setOnClickListener { v ->
            val letter = (v as Button).text.toString()
            val address = "https://www.google.com/search?q=$letter"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(address))
            it.button.context.startActivity(intent) // 에러났었음(context)
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            button.text = filteredWords[position]
        }
    }

    override fun getItemCount(): Int = filteredWords.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val button: Button = view.findViewById<Button>(R.id.btn_item)
    }

}