package racingcar.ui

import racingcar.Car
import racingcar.Race

class ResultView {
    fun print(race: Race) {
        race.cars.forEach { print(it) }
        println()
    }

    private fun print(car: Car) {
        for (i in 1..car.position) kotlin.io.print("-")
        println()
    }
}
