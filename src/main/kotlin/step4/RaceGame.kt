package step4

import step4.ExceptionType.ERROR_CAR_NAME

class RaceGame(private val carNames: List<String>, private val tryCount: Int) {
    companion object {
        private const val RANDOM_MAX = 9
        private const val RANDOM_MIN = 0
        private const val NAME_SIZE_LIMIT = 5
    }

    private val cars: List<Car>

    init
    {
        fun validate(carName: String) {
            require(carName.length <= NAME_SIZE_LIMIT) { ERROR_CAR_NAME }
        }

        fun validateCarNames() {
            carNames.forEach { validate(it) }
        }

        validateCarNames()
        cars = carNames.map { Car(it) }
    }

    fun playGame(): String {
        for (i in 1..tryCount) {
            moveCars()
            printCurrentPositions()
        }
        return determineWinners()
    }

    private fun moveCars() {
        cars.forEach { it.move(randomMove()) }
    }

    private fun randomMove(): Int {
        return (RANDOM_MIN..RANDOM_MAX).random()
    }

    private fun printCurrentPositions() {
        cars.forEach {
            println("${it.name} : ${"-".repeat(it.position)}")
        }
        println()
    }

    private fun determineWinners(): String {
        val maxPosition = getMaxPosition()
        val winnersNames = getWinners(maxPosition)
        return winnersNames
    }

    private fun getMaxPosition(): Int {
        return cars.map { it.position }
            .maxOrNull()!!
    }

    private fun getWinners(maxPosition: Int): String =
        cars.filter { it.position == maxPosition }
            .joinToString(", ") { it.name }
}
