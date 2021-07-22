package com.gmail.wil.myvocabularynotebook.model

data class PhrasalVerb(
    val idPhrasalVerb: String,
    val idVerb: String,
    override val idMeaning: String,
    override val idTermVocabulary: String,
    override val mainDescription: String,
    override val secondaryDescription: String,
    override val englishExample: String,
    override val spanishExample: String
) : Meaning()

