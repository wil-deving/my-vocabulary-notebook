package com.gmail.wil.myvocabularynotebook.implementation

import android.content.ContentValues
import android.content.Context
import com.gmail.wil.myvocabularynotebook.`interface`.IConexion
import com.gmail.wil.myvocabularynotebook.`interface`.IMeaning
import com.gmail.wil.myvocabularynotebook.dataSource.Constants
import com.gmail.wil.myvocabularynotebook.dataSource.DatabaseAdapter
import com.gmail.wil.myvocabularynotebook.model.Common
import com.gmail.wil.myvocabularynotebook.model.Meaning

class CommonImpl(context: Context) : IMeaning {

    private var db: IConexion? = null
    private var meaningImpl : MeaningImpl? = null

    init {
        db = DatabaseAdapter(context)
        db!!.open()
        meaningImpl = MeaningImpl(context)
    }

    override fun save(meaning: Meaning) : Long {
        val meaningSavedResponse = meaningImpl!!.save(meaning)
        if (meaningSavedResponse <= 0L) return 0L
        val common = meaning as Common
        val formSavedResponse = meaningImpl!!.saveFormData(common.idMeaning, common.idType)
        if (formSavedResponse <= 0L) return 0L
        return save(common)
    }

    private fun save(common: Common) : Long {
        db!!.open()
        val contentValues = ContentValues()
        contentValues.put(Constants.COMMON_ID_TYPE, common.idType)
        contentValues.put(Constants.COMMON_TYPE, common.type)
        val dbResp = db!!.saveData(Constants.TABLE_COMMON, contentValues)
        db!!.close()
        return dbResp
    }

    override fun update() {

    }

    override fun delete() {

    }


}