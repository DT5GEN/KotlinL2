package com.example.kotlinl2.lesson3

class Producer<out T> {  // "ковариантный в параметре Т"
    fun produce (): Producer<T> {
return this
    }
}