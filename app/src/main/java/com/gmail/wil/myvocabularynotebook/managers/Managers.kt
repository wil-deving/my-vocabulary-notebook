package com.gmail.wil.myvocabularynotebook.managers

import com.gmail.wil.myvocabularynotebook.model.Meaning

fun randomAlphanumericString(): String {
    val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    val outputStrLength = (1..36).shuffled().first()
    return (1..outputStrLength)
        .map{ kotlin.random.Random.nextInt(0, charPool.size) }
        .map(charPool::get)
        .joinToString("")
}

fun compareMeanings(textOne: String = "", textTwo: String = "") : Boolean {
    val toCaseTextOne = textOne.trim().toUpperCase()
    val toCaseTextTwo = textTwo.trim().toUpperCase()
    if (toCaseTextOne == toCaseTextTwo) return true
    else {
        val sptTextOne = toCaseTextOne.split(" ")
        val sptTextTwo = toCaseTextTwo.split(" ")
        val calculateWeightByWord = ((1.00 / sptTextOne.size.toDouble()) * 100.00 )
        var sumWeightTotal = 0.00
        for (wordInTwo in sptTextTwo) {
            if (wordInTwo in sptTextOne) sumWeightTotal += calculateWeightByWord
            else sumWeightTotal -= (calculateWeightByWord / 25.00)
        }
        println("------->" + sumWeightTotal)
        return (sumWeightTotal > 25.00)
    }
}

// This function receives two list and mix them and shuffle those list and return
fun messArrayToList(corrects: ArrayList<Meaning>, wrongs: ArrayList<Meaning>) : ArrayList<Meaning> {
    val finalArrayList = ArrayList<Meaning>()
    // Get list of correct shuffled (a item doesn't have more than 100 meanings!)
    val finalCorrects = getShuffledForNumber(corrects, 100)
    // To add correct list to list to return
    finalArrayList.addAll(finalCorrects)
    // Get list of wrongs shuffled and only 3 items
    val finalWrongs = getShuffledForNumber(wrongs, 3)
    // To add this list to list of return
    finalArrayList.addAll(finalWrongs)
    // To shuffle all of items in  list return
    finalArrayList.shuffle()
    return finalArrayList
}

// This function recieve a list to shuffle having as limit count parameter
fun getShuffledForNumber(list: ArrayList<Meaning>, count: Int) : ArrayList<Meaning> {
    val arrayCounted = ArrayList<Meaning>()
    list.shuffle()
    var j = 1
    for (i in list) {
        if (j <= count) {
            arrayCounted.add(i)
        }else {
            break
        }
        j++
    }
    return arrayCounted
}