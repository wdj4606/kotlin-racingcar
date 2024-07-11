package step3

class RaceGame(private val cars: List<Car>, private val rounds: Int) {
    fun runRace() {
        for (round in 1..rounds) {
            cars.forEach { it.move() }
            ResultView.printRoundResult(cars)
        }
    }
}
