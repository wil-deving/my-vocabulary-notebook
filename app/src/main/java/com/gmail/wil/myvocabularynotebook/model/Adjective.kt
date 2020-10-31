package com.gmail.wil.myvocabularynotebook.model

data class Adjective(val idAdjective: String,
                val comparative: String = "",
                val superlative: String = "",
                val withAuxiliar: Boolean) : Meaning() {

}