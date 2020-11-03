package com.gmail.wil.myvocabularynotebook.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gmail.wil.myvocabularynotebook.R
import com.gmail.wil.myvocabularynotebook.implementation.CommonImpl
import com.gmail.wil.myvocabularynotebook.implementation.TermImpl
import kotlinx.android.synthetic.main.activity_add_common.*

class AddCommonActivity : AppCompatActivity() {

    var term : TermImpl? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_common)

        term = TermImpl(this)

        btnAnotherMeaningCommon.setOnClickListener {

            val termVocabulary = etTermCommon!!.text.toString()
            val mainMeaning = etMainMeaningCommon!!.text.toString()
            val secondaryMeaning = etSecondMeaningCommon!!.text.toString()
            val engExample = etEngExampleCommon!!.text.toString()
            val espExample = etEspExampleCommon!!.text.toString()

             val resp = term!!.saveTerm(termVocabulary)

            Toast.makeText(this, "EXITO $resp", Toast.LENGTH_SHORT).show()
//            val commonI = CommonImpl()
//            commonI.saveNewCommon("")



        }
    }
}