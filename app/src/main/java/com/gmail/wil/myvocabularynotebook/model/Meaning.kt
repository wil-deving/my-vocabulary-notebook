package com.gmail.wil.myvocabularynotebook.model

import com.gmail.wil.myvocabularynotebook.`interface`.IMeaning

abstract class Meaning {

     abstract val idMeaning: String
     abstract val idTermVocabulary: String
     abstract val mainDescription: String
     abstract val secondaryDescription: String
     abstract val englishExample: String
     abstract val spanishExample: String

}
