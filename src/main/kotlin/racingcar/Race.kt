package racingcar

class Race(
    carNames: List<String>,
    val cars: List<Car> = carNames.map { Car(it) }
) {

    fun race() {
        cars.forEach { it.race(); }
    }
}
