package com.gmail.wil.myvocabularynotebook.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gmail.wil.myvocabularynotebook.R

class TermsLearnedFragment(context: Context) : Fragment() {

    val con = context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_terms_learned, container, false)
    }

}