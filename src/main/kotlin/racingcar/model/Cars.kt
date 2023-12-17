package racingcar.model

import racingcar.dto.CarDto

class Cars(
    private val cars: LinkedHashSet<Car> = linkedSetOf(),
) {
    fun add(car: Car) {
        cars.add(car)
    }

    fun move() {
        cars.forEach { it.move() }
    }

    fun getCars(): List<CarDto> {
        return cars.map { it.toDto() }
    }

    fun getMaxPosition(): Int {
        return cars.maxOfOrNull { it.position } ?: 0
    }

    fun filter(predicate: (Car) -> Boolean): Cars {
        return from(cars.filter(predicate))
    }

    companion object {
        fun from(cars: List<Car>): Cars {
            return Cars().apply {
                cars.forEach { add(it) }
            }
        }
    }
}
