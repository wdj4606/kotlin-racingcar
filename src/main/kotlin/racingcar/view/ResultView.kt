package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Race

class ResultView {
    fun printCarPosition(race: Race) {
        race.forEach { printCarPosition(it) }
        println()
    }

    private fun printCarPosition(car: Car) {
        print("${car.name} : ")
        repeat(car.position + 1) {
            print("-")
        }
        println()
    }

    fun printWinner(race: Race) {
        val winnerNames = race.getWinners().joinToString(",") { it.name }
        println("$winnerNames is winner!")
    }
}
