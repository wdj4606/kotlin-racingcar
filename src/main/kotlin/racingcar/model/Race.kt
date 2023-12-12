package racingcar.model

import racingcar.dto.CarDto

class Race(
    private val cars: LinkedHashSet<Car>
) {
    fun moveOneTick() {
        cars.forEach { it.move() }
    }

    fun getCarInfo(): List<CarDto> {
        return cars.map { it.toDto() }
    }

    companion object {
        fun from(carNum: Int): Race {
            val cars = linkedSetOf<Car>()
            repeat(carNum) { cars.add(Car()) }
            return Race(cars)
        }
    }
}
