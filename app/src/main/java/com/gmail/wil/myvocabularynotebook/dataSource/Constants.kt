package com.gmail.wil.myvocabularynotebook.dataSource
object Constants {

    // Table Term
    val TABLE_TERM = "termvocabulary"
    // Term columns
    val TERM_ID_TERM_VOCABULARY = "idtermvocabulary"
    val TERM_TERM_DESC = "term"
    val TERM_LEARNED = "learned"

    // Table Practice
    val TABLE_PRACTICE = "practice"
    // Practice columns
    val PRACTICE_ID_PRACTICE = "idpractice"
    val PRACTICE_ID_MEANING = "idmeaning"
    val PRACTICE_TO_COUNT = "tocount"

    // Table Meaning
    val TABLE_MEANING = "meaning"
    // Meaning columns
    val MEANING_ID_MEANING = "idmeaning"
    val MEANING_ID_TERM_VOCABULARY = "idtermvocabulary"
    val MEANING_MAIN_DESC = "maindescription"
    val MEANING_SECONDARY_DESC = "secondarydescription"
    val MEANING_ENG_EXAMPLE = "englishexample"
    val MEANING_ESP_EXAMPLE = "spanishexample"

    // Table Form
    val TABLE_FORM = "form"
    // Form columns
    val FORM_ID_FORM = "idform"
    val FORM_ID_MEANING = "idmeaning"

    // Table Verb
    val TABLE_VERB = "verb"
    // Verb columns
    val VERB_ID_VERB = "idverb"
    val VERB_CONTINUOUS = "continuous"
    val VERB_PAST_SIMPLE = "pastsimple"
    val VERB_PAST_PERFECT = "pastperfect"

    // Table Phrasal verb
    val TABLE_PHRASAL_VERB = "phrasalverb"
    // Phrasal verb columns
    val PHRASAL_VERB_ID_PHRASAL_VERB = "idphrasalverb"
    val PHRASAL_VERB_ID_VERB = "idverb"

    // Table Adjective
    val TABLE_ADJECTIVE = "adjective"
    // Adjective columns
    val ADJECTIVE_ID_ADJECTIVE = "idadjective"
    val ADJECTIVE_COMPARATIVE = "comparative"
    val ADJECTIVE_SUPERLATIVE = "superlative"
    val ADJECTIVE_WITH_AUX = "withauxiliar"

    // Table Noun
    val TABLE_NOUN = "noun"
    // Noun columns
    val NOUN_ID_NOUN = "idnoun"
    val NOUN_PLURAL = "plural"

    // Table Common
    val TABLE_COMMON = "common"
    // Common columns
    val COMMON_ID_TYPE = "idtype"
    val COMMON_TYPE = "type"

}