package com.gmail.wil.myvocabularynotebook.model

data class Adjective(
    val idAdjective: String,
    val comparative: String = "",
    val superlative: String = "",
    val withAuxiliar: Boolean,
    override val idMeaning: String,
    override val idTermVocabulary: String,
    override val mainDescription: String,
    override val secondaryDescription: String,
    override val englishExample: String,
    override val spanishExample: String
) : Meaning()

