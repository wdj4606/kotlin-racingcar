package step3

data class CarList(val carList: List<Car>)

class RaceGame(private var cars: CarList, private val rounds: Int) {

    companion object {
        private const val RANDOM_MAX = 9
        private const val RANDOM_MIN = 0
    }

    fun runRace(): List<CarList> {
        val result = mutableListOf<CarList>()

        repeat(rounds) {
            runRound()
            result.add(CarList(copyCars(cars).carList))
        }

        return result
    }

    private fun runRound() {
        val movedCars = cars.carList.map { car ->
            car.move(randomMove())
            car
        }
        cars = CarList(movedCars)
    }

    private fun copyCars(cars: CarList): CarList {
        val copiedCars = cars.carList.map { Car(it.position) }
        return CarList(copiedCars)
    }

    private fun randomMove(): Int {
        return (RANDOM_MIN..RANDOM_MAX).random()
    }
}
