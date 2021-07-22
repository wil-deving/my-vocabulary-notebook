package com.gmail.wil.myvocabularynotebook.model

import com.gmail.wil.myvocabularynotebook.`interface`.IMeaning

data class Verb(
    val idVerb: String,
    val continuous: String,
    val pastSimple: String,
    val pastPerfect: String,
    override val idMeaning: String,
    override val idTermVocabulary: String,
    override val mainDescription: String,
    override val secondaryDescription: String,
    override val englishExample: String,
    override val spanishExample: String
) : Meaning()