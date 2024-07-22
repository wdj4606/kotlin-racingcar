package step4.domain

import step4.ExceptionType.ERROR_EMPTY_CAR_LIST
import step4.domain.Randomizer.getRandom

data class RoundSet(val carList: List<RacingCar>)

class RaceGame(private val cars: List<RacingCar>, private val rounds: Int) {
    private val raceHistory = mutableListOf<RoundSet>()

    fun getRaceHistory(): List<RoundSet> {
        return raceHistory
    }

    fun playGame(): String {
        raceHistory.clear()
        repeat(rounds) {
            moveCars()
        }
        return determineWinners()
    }

    private fun moveCars() {
        cars.forEach { it.play(getRandom()) }
        val movedCars = cars.map { RacingCar(it.name, it.position) }
        raceHistory.add(RoundSet(movedCars))
    }

    private fun determineWinners(): String {
        val maxPosition = getMaxPosition()
        val winnersNames = getWinners(maxPosition)
        return winnersNames
    }

    private fun getMaxPosition(): Int {
        return cars.map { it.position }
            .maxOrNull() ?: throw IllegalStateException(ERROR_EMPTY_CAR_LIST)
    }

    private fun getWinners(maxPosition: Int): String =
        cars.filter { it.position == maxPosition }
            .joinToString(", ") { it.name }
}
