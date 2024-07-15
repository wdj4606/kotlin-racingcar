package step4

data class RoundSet(val carList: List<Car>)

class RaceGame(private val cars: List<Car>, private val rounds: Int) {
    companion object {
        private const val RANDOM_MAX = 9
        private const val RANDOM_MIN = 0
    }

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
        cars.forEach { it.move(randomMove()) }
        val movedCars = cars.map { Car(it.name, it.position) }
        raceHistory.add(RoundSet(movedCars))
    }

    private fun randomMove(): Int {
        return (RANDOM_MIN..RANDOM_MAX).random()
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
