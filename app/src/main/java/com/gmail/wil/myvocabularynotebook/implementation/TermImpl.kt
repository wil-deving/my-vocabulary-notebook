package com.gmail.wil.myvocabularynotebook.implementation

import android.content.ContentValues
import android.content.Context
import com.gmail.wil.myvocabularynotebook.`interface`.IConexion
import com.gmail.wil.myvocabularynotebook.`interface`.ITerm
import com.gmail.wil.myvocabularynotebook.dataSource.Constants
import com.gmail.wil.myvocabularynotebook.dataSource.DatabaseAdapter

class TermImpl(context: Context) : ITerm {

    private var db: IConexion? = null

    init {
        db = DatabaseAdapter(context)
        db!!.open()
    }


    override fun saveTerm(id: String, term: String) : Long {
        db!!.open()
        val contentValues = ContentValues()
        contentValues.put(Constants.TERM_ID_TERM_VOCABULARY, id)
        contentValues.put(Constants.TERM_TERM_DESC, term)
        contentValues.put(Constants.TERM_LEARNED, 0)
        val dbResp = db!!.saveData(Constants.TABLE_TERM, contentValues)
        // dbResp que es la respuesta sera correcto cuando sea > 0 sino es error SQLite
        db!!.close()
        return dbResp
    }

    override fun updateTerm() {
        TODO("Not yet implemented")
    }

    override fun deleteTerm() {
        TODO("Not yet implemented")
    }
}