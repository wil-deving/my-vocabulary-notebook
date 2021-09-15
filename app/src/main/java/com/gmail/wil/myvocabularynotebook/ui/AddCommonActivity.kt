package com.gmail.wil.myvocabularynotebook.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.gmail.wil.myvocabularynotebook.R
import com.gmail.wil.myvocabularynotebook.Utils.createDialog
import com.gmail.wil.myvocabularynotebook.implementation.CommonImpl
import com.gmail.wil.myvocabularynotebook.implementation.TermImpl
import com.gmail.wil.myvocabularynotebook.internalStorage.InternalSharedStorage
import com.gmail.wil.myvocabularynotebook.Utils.randomAlphanumericString
import com.gmail.wil.myvocabularynotebook.model.Common
import kotlinx.android.synthetic.main.activity_add_common.*

class AddCommonActivity : AppCompatActivity() {

    var term : TermImpl? = null
    var common : CommonImpl? = null
    var typeTerm: String? = null
    lateinit var sharedPreferences: InternalSharedStorage


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_common)

        typeTerm = intent.getStringExtra("termType").toString()

        term = TermImpl(this)
        common = CommonImpl(this)
        sharedPreferences = InternalSharedStorage(application)

        // TODO TD testing Shared preferences, it works!!!
        //sharedPreferences.saveTermData("Hello World")
        //val ttt = sharedPreferences.getTerm()

    }

    fun savingData() {
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
        val respTermSaved = term!!.saveTerm(termId, vocabularyTerm)
        if (respTermSaved > 0L) {
            val respMeaningSaved = common!!.save(vocabularyMeaning)
            if (respMeaningSaved > 0L) {
                val intent = Intent(this, SelectTypeActivity::class.java)
                startActivity(intent)
                return
                //Toast.makeText(this, "EXITO AL GUARDAR DATOS $respMeaningSaved", Toast.LENGTH_SHORT).show()
            }
        }
        Toast.makeText(this, "ERROR AL GUARDAR DATOS", Toast.LENGTH_SHORT).show()
    }

    fun addAnotherMeaning(view: View) {

        // TODO TD must be validates here
        // this::savingData is function to call on positive button
        createDialog(this, "titulo", "pregunta", this::savingData).show()

    }

    fun saveAndFinish(view: View) {

    }
}