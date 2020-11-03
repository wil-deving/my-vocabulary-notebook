package com.gmail.wil.myvocabularynotebook.`interface`

interface ITerm {

    fun saveTerm(term: String) : String
    fun updateTerm()
    fun deleteTerm()
}