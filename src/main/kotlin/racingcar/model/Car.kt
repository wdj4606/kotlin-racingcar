package racingcar.model

import racingcar.dto.CarDto

class Car(
    val name: String,
    private val movableStrategy: MovableStrategy = RandomMovableStrategy(),
) {
    var position: Int = 0
        private set

    fun move() {
        if (movableStrategy.isMovable()) {
            position++
        }
    }

    fun toDto(): CarDto {
        return CarDto(name, position)
    }
}
