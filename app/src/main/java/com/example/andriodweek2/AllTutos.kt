package com.example.andriodweek2

import android.R

fun main() {
    val userName = "Aymen"
    val  password = "12345678"
    tuto101(userName, password)
    tuto102(password)
    tuto103()
}

fun tuto101(userName: String, password: String): Unit
{
    if (userName === "ahmed" && password === "1122334455") println("Welcome in Ahmed")
    else if (userName === "Aymen" && password === "12345678") println("Welcome in Aymen")
    else println("Invalid Data")
}

fun tuto102(str: String?): Unit
{
    println(str?.length ?: 0)
}

fun tuto103()
{
    val car = Car("red", "mrecidce", "benz", "v12")
    car.run()
    class Car(var color: String, var type: String, var model: String, var engine: String)
    {

        public fun run(){
            println("the $type $model $color car is going off with engine of $engine")
        }

        public fun getColor(): String
        {
            return this.color
        }
        public fun setColor(color: String)
        {
            this.color = color
        }
        public fun getType(): String
        {
            return this.type
        }
        public fun setType(type: String)
        {
            this.type = type
        }
        public fun getModel(): String
        {
        return this.model
        }
        public fun setModel(model: String)
        {
            this.model = model
        }
        public fun getEngine(): String
        {
        return this.engine
        }
        public fun setEngine(engine: String)
        {
            this.engine = engine
        }
    }
}