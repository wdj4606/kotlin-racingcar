package step4.view

import step4.domain.RoundSet

object ResultView {
    private const val WINNER = "%s가 최종 우승했습니다."

    fun printHistory(raceHistory: List<RoundSet>) {
        raceHistory.forEach { roundSet ->
            printPosition(roundSet)
        }
        println()
    }

    fun printPosition(roundSet: RoundSet) {
        roundSet.carList.forEach { car ->
            println("${car.name}: ${"-".repeat(car.position)}")
        }
        println()
    }

    fun printWinners(winners: String) {
        print(WINNER.format(winners))
    }
}
