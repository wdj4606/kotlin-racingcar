package step3.ui

import step3.Car

object OutputView {

    var cars: MutableList<Car> = mutableListOf()

    fun printResult() {
        cars.forEach {
            it.move()
            println("-".repeat(it.position))
        }
        println()
    }
}
