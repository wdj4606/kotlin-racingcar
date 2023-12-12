package racingcar.model

import racingcar.dto.CarDto

class Car(
    movableStrategy: MovableStrategy = MovableStrategy { true },
) : Movable(movableStrategy) {
    fun toDto(): CarDto {
        return CarDto(position)
    }
}
