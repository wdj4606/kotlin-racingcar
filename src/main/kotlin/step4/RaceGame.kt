package step4

private const val RANDOM_MAX = 9
private const val RANDOM_MIN = 0
private const val NAME_SIZE_LIMIT = 5

private const val ERROR_CAR_NAME = "자동차 이름은 5자를 초과할 수 없습니다."

class RaceGame(private val carNames: List<String>, private val tryCount: Int) {
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
