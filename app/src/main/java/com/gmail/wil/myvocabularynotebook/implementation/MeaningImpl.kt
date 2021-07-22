package com.gmail.wil.myvocabularynotebook.implementation

import android.content.ContentValues
import android.content.Context
import com.gmail.wil.myvocabularynotebook.`interface`.IConexion
import com.gmail.wil.myvocabularynotebook.`interface`.IMeaning
import com.gmail.wil.myvocabularynotebook.dataSource.Constants
import com.gmail.wil.myvocabularynotebook.dataSource.DatabaseAdapter
import com.gmail.wil.myvocabularynotebook.model.Common
import com.gmail.wil.myvocabularynotebook.model.Meaning

open class MeaningImpl(context: Context) : IMeaning {

    private var db: IConexion? = null

    init {
        db = DatabaseAdapter(context)
        db!!.open()
    }

    override fun save(meaning: Meaning) : Long {
        db!!.open()
        val contentValues = ContentValues()
        contentValues.put(Constants.MEANING_ID_MEANING, meaning.idMeaning)
        contentValues.put(Constants.MEANING_ID_TERM_VOCABULARY, meaning.idTermVocabulary)
        contentValues.put(Constants.MEANING_MAIN_DESC, meaning.mainDescription)
        contentValues.put(Constants.MEANING_SECONDARY_DESC, meaning.secondaryDescription)
        contentValues.put(Constants.MEANING_ENG_EXAMPLE, meaning.englishExample)
        contentValues.put(Constants.MEANING_ESP_EXAMPLE, meaning.spanishExample)
        val dbResp = db!!.saveData(Constants.TABLE_MEANING, contentValues)
        db!!.close()
        return dbResp
    }

    fun saveFormData(idMeaning: String, idForm: String) : Long {
        db!!.open()
        val contentValues = ContentValues()
        contentValues.put(Constants.FORM_ID_MEANING, idMeaning)
        contentValues.put(Constants.FORM_ID_FORM, idForm)
        val dbResp = db!!.saveData(Constants.TABLE_FORM, contentValues)
        db!!.close()
        return dbResp
    }

    override fun update() {
        TODO("Not yet implemented")
    }

    override fun delete() {
        TODO("Not yet implemented")
    }

}