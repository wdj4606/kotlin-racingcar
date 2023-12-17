package racingcar.model

import racingcar.dto.CarDto

class Race(
    private val cars: Cars,
) {

    fun race(): List<CarDto> {
        return cars.run {
            move()
            getCars()
        }
    }

    fun getWinners(): List<CarDto> {
        return cars.run {
            val maxPosition = getMaxPosition()
            filter { it.position == maxPosition }.getCars()
        }
    }

    companion object {
        fun from(carNames: List<String>): Race {
            return carNames
                .map { Car(it, RandomMovableStrategy()) }
                .let { Cars.from(it) }
                .let { Race(it) }
        }
    }
}
