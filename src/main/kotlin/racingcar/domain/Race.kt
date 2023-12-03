package racingcar.domain

class Race(
    carNames: List<String>,
    val cars: List<Car> = carNames.map { Car(it) }
) : List<Car> by cars {

    fun race() {
        forEach { it.race() }
    }

    fun getWinners(): List<Car> {
        val maxPosition = maxByOrNull { it.position }
            ?: throw IllegalStateException("can not be possible")
        return filter { it.position >= maxPosition.position }
    }
}
