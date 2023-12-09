package View

import Model.Car
import Model.Race

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val number = readln().toInt()
    println("시도할 회수는 몇 회인가요?")
    val count = readln().toInt()

    val cars = ArrayList<Car>()
    for (num in 1..number) {
        cars.add(Car(num.toString()))
    }
    Race(cars, count)
}
