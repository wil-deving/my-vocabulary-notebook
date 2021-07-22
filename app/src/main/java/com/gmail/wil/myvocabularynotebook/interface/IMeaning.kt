package com.gmail.wil.myvocabularynotebook.`interface`

import com.gmail.wil.myvocabularynotebook.model.Common
import com.gmail.wil.myvocabularynotebook.model.Meaning

interface IMeaning {

    fun save(meaning: Meaning) : Long
    fun update()
    fun delete()

}