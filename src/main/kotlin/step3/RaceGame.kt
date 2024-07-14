package step3

class RaceGame(private val cars: List<Car>, private val rounds: Int) {

    fun runRace(): List<List<Car>> {
        val raceResult = mutableListOf<List<Car>>()
        repeat(rounds) {
            cars.forEach { car ->
                car.move(randomMove())
            }
            val movedCars = cars.map { Car(it.position) }
            raceResult.add(movedCars)
        }
        return raceResult
    }

    private fun randomMove(): Int {
        return (Constants.RANDOM_MIN..Constants.RANDOM_MAX).random()
    }
}
