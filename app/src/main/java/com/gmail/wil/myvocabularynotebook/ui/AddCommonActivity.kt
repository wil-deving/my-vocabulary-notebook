package com.gmail.wil.myvocabularynotebook.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gmail.wil.myvocabularynotebook.R
import com.gmail.wil.myvocabularynotebook.implementation.CommonImpl
import com.gmail.wil.myvocabularynotebook.implementation.MeaningImpl
import com.gmail.wil.myvocabularynotebook.implementation.TermImpl
import com.gmail.wil.myvocabularynotebook.managers.randomAlphanumericString
import com.gmail.wil.myvocabularynotebook.model.Common
import com.gmail.wil.myvocabularynotebook.model.Meaning
import kotlinx.android.synthetic.main.activity_add_common.*

class AddCommonActivity : AppCompatActivity() {

    var term : TermImpl? = null
    var common : CommonImpl? = null
    var typeTerm: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_common)

        typeTerm = intent.getStringExtra("termType").toString()

        // review if it is sending all data to DATABASE adapter
        term = TermImpl(this)
        common = CommonImpl(this)

        btnAnotherMeaningCommon.setOnClickListener {

            val termId = randomAlphanumericString()

            val vocabularyTerm = etTermCommon!!.text.toString()
            val mainMeaning = etMainMeaningCommon!!.text.toString()
            val secondaryMeaning = etSecondMeaningCommon!!.text.toString()
            val engExample = etEngExampleCommon!!.text.toString()
            val espExample = etEspExampleCommon!!.text.toString()

            val vocabularyMeaning = Common(
                idType = randomAlphanumericString(),
                type = typeTerm.toString(),
                idMeaning = randomAlphanumericString(),
                idTermVocabulary = termId,
                mainDescription = mainMeaning,
                secondaryDescription = secondaryMeaning,
                englishExample = engExample,
                spanishExample = espExample
            )

            // TODO Make readme file and upload to Github

            val respTermSaved = term!!.saveTerm(termId, vocabularyTerm)
            if (respTermSaved > 0L) {
                val respMeaningSaved = common!!.save(vocabularyMeaning)
                if (respMeaningSaved > 0L)
                    Toast.makeText(this, "EXITO AL GUARDAR DATOS $respTermSaved $respMeaningSaved", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this, "ERROR AL GUARDAR DATOS", Toast.LENGTH_SHORT).show()

        }
    }
}