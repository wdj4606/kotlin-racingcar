package racingcar

class Race(
    carNames: List<String>,
    val cars: List<Car> = carNames.map { Car(it) }
) {

    fun race() {
        cars.forEach { it.race(); }
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxByOrNull { it.position }
            ?: throw IllegalStateException("can not be possible")
        return cars.filter { it.position >= maxPosition.position }
    }
}
