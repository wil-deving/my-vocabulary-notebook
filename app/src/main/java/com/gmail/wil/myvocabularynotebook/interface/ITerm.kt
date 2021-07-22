package com.gmail.wil.myvocabularynotebook.`interface`

interface ITerm {

    fun saveTerm(id: String, term: String) : Long
    fun updateTerm()
    fun deleteTerm()
}