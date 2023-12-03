package racingcar.ui

import racingcar.Car
import racingcar.Race

class ResultView {
    fun print(race: Race) {
        race.cars.forEach { print(it) }
        println()
    }

    private fun print(car: Car) {
        repeat(car.position + 1) {
            print("-")
        }
        println()
    }
}
