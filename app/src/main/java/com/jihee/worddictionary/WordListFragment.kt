package com.jihee.worddictionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.jihee.worddictionary.databinding.FragmentWordListBinding

class WordListFragment : Fragment() {

    val args by navArgs<WordListFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<FragmentWordListBinding>(
            inflater,
            R.layout.fragment_word_list,
            container,
            false
        ).run {
            textview.text = args.letter

            root
        }
    }
}