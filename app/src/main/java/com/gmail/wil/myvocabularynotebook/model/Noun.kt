package com.gmail.wil.myvocabularynotebook.model

data class Noun(
    val idNoun: String,
    val plural: String = "",
    override val idMeaning: String,
    override val idTermVocabulary: String,
    override val mainDescription: String,
    override val secondaryDescription: String,
    override val englishExample: String,
    override val spanishExample: String
): Meaning() {


}