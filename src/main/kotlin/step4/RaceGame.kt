package step4

class RaceGame(private val cars: List<Car>, private val tryCount: Int) {
    companion object {
        private const val RANDOM_MAX = 9
        private const val RANDOM_MIN = 0
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
