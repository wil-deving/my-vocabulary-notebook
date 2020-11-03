package com.gmail.wil.myvocabularynotebook.dataSource

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.gmail.wil.myvocabularynotebook.`interface`.IConexion

class DatabaseAdapter(context: Context) : IConexion {
    private val databaseHelper: VocabularyDatabaseHelper
    private var db: SQLiteDatabase? = null

    init {
        databaseHelper = VocabularyDatabaseHelper(context)
    }

    override fun open() {
        db = databaseHelper.writableDatabase
    }

    override fun close() {
        databaseHelper.close()
    }

    override fun getData() {

    }

    override fun saveData(TABLE: String, CONTENTVALUES: ContentValues) : Long {
        val contentValues = ContentValues()
        return db!!.insert("TABLE", null, CONTENTVALUES)
    }

    override fun updateData() {

    }

    override fun deleteData() {

    }

    private class VocabularyDatabaseHelper(context: Context) : SQLiteOpenHelper(context,
        "dbvocabularynotebook.db", null, 1) {

        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL(
                "CREATE TABLE ${Constants.TABLE_TERM} (" +
                        "${Constants.TERM_ID_TERM_VOCABULARY} TEXT PRIMARY KEY, " +
                        "${Constants.TERM_TERM_DESC} TEXT NOT NULL, " +
                        "${Constants.TERM_LEARNED} INTEGER )"
            )
            db.execSQL(
                "CREATE TABLE ${Constants.TABLE_MEANING} (" +
                        "${Constants.MEANING_ID_MEANING} TEXT PRIMARY KEY, " +
                        "${Constants.MEANING_ID_TERM_VOCABULARY} TEXT NOT NULL, " +
                        "${Constants.MEANING_MAIN_DESC} TEXT NOT NULL, " +
                        "${Constants.MEANING_SECONDARY_DESC} TEXT NOT NULL, " +
                        "${Constants.MEANING_ENG_EXAMPLE} TEXT, " +
                        "${Constants.MEANING_ESP_EXAMPLE} TEXT ) "
            )
            db.execSQL(
                "CREATE TABLE ${Constants.TABLE_PRACTICE} (" +
                        "${Constants.PRACTICE_ID_PRACTICE} TEXT NOT NULL, " +
                        "${Constants.PRACTICE_ID_MEANING} TEXT NOT NULL, " +
                        "${Constants.PRACTICE_TO_COUNT} INTEGER ) "
            )
            db.execSQL(
                "CREATE TABLE ${Constants.TABLE_FORM} (" +
                        "${Constants.FORM_ID_FORM} TEXT NOT NULL, " +
                        "${Constants.FORM_ID_MEANING} TEXT NOT NULL ) "
            )
            db.execSQL(
                "CREATE TABLE ${Constants.TABLE_PHRASAL_VERB} (" +
                        "${Constants.PHRASAL_VERB_ID_PHRASAL_VERB} TEXT PRIMARY KEY, " +
                        "${Constants.PHRASAL_VERB_ID_VERB} TEXT ) "
            )
            db.execSQL(
                "CREATE TABLE ${Constants.TABLE_VERB} (" +
                        "${Constants.VERB_ID_VERB} TEXT PRIMARY KEY, " +
                        "${Constants.VERB_CONTINUOUS} TEXT, " +
                        "${Constants.VERB_PAST_SIMPLE} TEXT, " +
                        "${Constants.VERB_PAST_PERFECT} TEXT ) "
            )
            db.execSQL(
                "CREATE TABLE ${Constants.TABLE_ADJECTIVE} (" +
                        "${Constants.ADJECTIVE_ID_ADJECTIVE} TEXT PRIMARY KEY, " +
                        "${Constants.ADJECTIVE_COMPARATIVE} TEXT, " +
                        "${Constants.ADJECTIVE_SUPERLATIVE} TEXT, " +
                        "${Constants.ADJECTIVE_WITH_AUX} INTEGER ) "
            )
            db.execSQL(
                "CREATE TABLE ${Constants.TABLE_NOUN} (" +
                        "${Constants.NOUN_ID_NOUN} TEXT PRIMARY KEY, " +
                        "${Constants.NOUN_PLURAL} TEXT ) "
            )
            db.execSQL(
                "CREATE TABLE ${Constants.TABLE_COMMON} (" +
                        "${Constants.COMMON_ID_TYPE} TEXT PRIMARY KEY, " +
                        "${Constants.COMMON_TYPE} TEXT NOT NULL ) "
            )
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL("DROP TABLE IF EXISTS ${Constants.TABLE_TERM}")
            db.execSQL("DROP TABLE IF EXISTS ${Constants.TABLE_MEANING}")
            db.execSQL("DROP TABLE IF EXISTS ${Constants.TABLE_PRACTICE}")
            db.execSQL("DROP TABLE IF EXISTS ${Constants.TABLE_FORM}")
            db.execSQL("DROP TABLE IF EXISTS ${Constants.TABLE_PHRASAL_VERB}")
            db.execSQL("DROP TABLE IF EXISTS ${Constants.TABLE_VERB}")
            db.execSQL("DROP TABLE IF EXISTS ${Constants.TABLE_ADJECTIVE}")
            db.execSQL("DROP TABLE IF EXISTS ${Constants.TABLE_NOUN}")
            db.execSQL("DROP TABLE IF EXISTS ${Constants.TABLE_COMMON}")
            onCreate(db)
        }
    }
}