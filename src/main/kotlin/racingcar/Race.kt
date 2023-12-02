package racingcar

class Race(
    carNum: Int,
    val cars: List<Car> = (1..carNum).map { Car() }
) {

    fun race() {
        cars.forEach { it.race(); }
    }
}
