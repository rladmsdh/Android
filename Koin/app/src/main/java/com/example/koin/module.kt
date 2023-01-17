package com.example.koin

class AA {
    fun name() : String = "AA"
}

class BB(aa:AA){
    fun name() : String = "BB"
}