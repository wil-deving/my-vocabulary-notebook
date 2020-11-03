package com.gmail.wil.myvocabularynotebook.`interface`

import android.content.ContentValues

interface IConexion {
    fun open()
    fun close()
    fun getData()
    fun saveData(TABLE: String, CONTENTVALUES: ContentValues) : Long
    fun updateData()
    fun deleteData()
}