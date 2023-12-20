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
        println(
            "${car.name} : ${"-".repeat(car.position)}"
        )
    }

    fun printWinner(cars: List<CarDto>) {
        cars
            .joinToString(
                separator = ", ",
                postfix = " 가 최종 우승했습니다."
            ) { it.name }
            .let { println(it) }
    }
}
