package com.gmail.wil.myvocabularynotebook.internalStorage

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

const val SHARED_TERM_FILE_NAME = "mvn_term_prefs"
const val TERM = "mvn_term"

class InternalSharedStorage(application: Application) {

    private var preferences: SharedPreferences =
        application.getSharedPreferences(SHARED_TERM_FILE_NAME, Context.MODE_PRIVATE)

    fun saveTermData(term: String) {
        preferences.edit().putString(TERM, term).apply()
    }

    fun getTerm() : String {
        return preferences.getString(TERM, "") ?: ""
    }

    fun clearTerm() {
        preferences.edit().remove(TERM)
    }
}