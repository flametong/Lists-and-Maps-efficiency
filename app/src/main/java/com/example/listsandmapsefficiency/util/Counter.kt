package com.example.listsandmapsefficiency.util

class Counter {

    companion object {
        private var count = 0
    }

    fun increase() {
        count++
    }

    fun reset () {
        count = 0
    }

    fun getCount(): Int = count
}