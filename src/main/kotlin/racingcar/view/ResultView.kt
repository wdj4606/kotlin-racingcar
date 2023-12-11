package racingcar.view

import racingcar.dto.CarDto

object ResultView {
    fun printCarStateHeader() {
        println("실행 결과")
    }

    fun printCarState(cars: List<CarDto>) {
        cars.forEach { printCarState(it) }
        println()
    }

    private fun printCarState(car: CarDto) {
        println("-".repeat(car.position))
    }
}
