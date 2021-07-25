package com.jihee.worddictionary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.jihee.worddictionary.databinding.FragmentLetterListBinding

class LetterListFragment : Fragment() {
    //View객체를 반환
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<FragmentLetterListBinding>(
            inflater,
            R.layout.fragment_letter_list,
            container,
            false
        ).run {
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = LetterAdapter()
            }

            root
        }
        //root : 최상단 뷰그룹
    }
}