package com.example.kotlinl2.lesson3

class Consumer<in T> {   // "контрвариативность в параметре Т"
    fun consume(param: T){

    }
}