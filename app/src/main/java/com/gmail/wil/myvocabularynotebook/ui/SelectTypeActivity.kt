package com.gmail.wil.myvocabularynotebook.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gmail.wil.myvocabularynotebook.R
import kotlinx.android.synthetic.main.activity_select_type.*

class SelectTypeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_type)

        btnVerb.setOnClickListener {
            val intent = Intent(this, AddVerbActivity::class.java)
            startActivity(intent)
        }

        btnAdjective.setOnClickListener {
            val intent = Intent(this, AddAdjectiveActivity::class.java)
            startActivity(intent)
        }

        btnNoun.setOnClickListener {
            val intent = Intent(this, AddNounActivity::class.java)
            startActivity(intent)
        }

        btnAdverb.setOnClickListener {
            startNewCommon("adv")
        }

        btnConjunction.setOnClickListener {
            startNewCommon("conj")
        }

        btnExpression.setOnClickListener {
            startNewCommon("exp")
        }

        btnPhrasalVerb.setOnClickListener {
            val intent = Intent(this, AddPhrasalVerbActivity::class.java)
            startActivity(intent)
        }

        btnPreposition.setOnClickListener {
            startNewCommon("prep")
        }

    }

    fun startNewCommon(type: String) {
        val intent = Intent(this, AddCommonActivity::class.java)
        // send a extra with type
        startActivity(intent)
    }
}