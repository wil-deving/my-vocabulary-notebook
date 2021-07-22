package com.gmail.wil.myvocabularynotebook.model

data class Common(
    val idType: String,
    val type: String,
    override val idMeaning: String,
    override val idTermVocabulary: String,
    override val mainDescription: String,
    override val secondaryDescription: String,
    override val englishExample: String,
    override val spanishExample: String
) : Meaning()