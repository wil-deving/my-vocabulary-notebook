package com.gmail.wil.myvocabularynotebook.implementation

import com.gmail.wil.myvocabularynotebook.`interface`.IMeaning

abstract class MeaningImpl : IMeaning {

    abstract override fun saveMeaning()
    abstract override fun updateMeaning()
    abstract override fun deleteMeaning()

}