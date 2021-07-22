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
            finish()
        }

        btnAdjective.setOnClickListener {
            val intent = Intent(this, AddAdjectiveActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnNoun.setOnClickListener {
            val intent = Intent(this, AddNounActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnAdverb.setOnClickListener {
            startNewCommon("adverb")
        }

        btnPreposition.setOnClickListener {
            startNewCommon("preposition")
        }

        btnConjunction.setOnClickListener {
            startNewCommon("conjunction")
        }

        btnPhrasalVerb.setOnClickListener {
            val intent = Intent(this, AddPhrasalVerbActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnExpression.setOnClickListener {
            startNewCommon("expression")
        }

    }

    fun startNewCommon(type: String) {
        val intent = Intent(this, AddCommonActivity::class.java)
        // send a extra with type
        intent.putExtra("termType", type)
        startActivity(intent)
        finish()
    }
}