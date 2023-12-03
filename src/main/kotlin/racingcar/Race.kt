package racingcar

class Race(
    carNum: Int,
    val cars: List<Car> = List(carNum) { Car() }
) {

    fun race() {
        cars.forEach { it.race(); }
    }
}
