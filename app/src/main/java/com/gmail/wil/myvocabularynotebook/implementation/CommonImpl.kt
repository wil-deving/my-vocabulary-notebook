package com.gmail.wil.myvocabularynotebook.implementation

import com.gmail.wil.myvocabularynotebook.`interface`.IMeaning

class CommonImpl : MeaningImpl() {



    fun saveNewCommon(term: String) {
        saveMeaning()

    }
}