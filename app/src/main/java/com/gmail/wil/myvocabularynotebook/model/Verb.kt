package com.gmail.wil.myvocabularynotebook.model

import com.gmail.wil.myvocabularynotebook.`interface`.IMeaning

data class Verb(val idVerb: String,
                val continuous: String,
                val pastSimple: String,
                val pastPerfect: String) : Meaning() {

}