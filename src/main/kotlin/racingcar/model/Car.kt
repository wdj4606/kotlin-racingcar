package racingcar.model

import racingcar.dto.CarDto

class Car(
    movableStrategy: RandomMovableStrategy = RandomMovableStrategy(),
) : Movable() {
    init {
        setMovableStrategy(movableStrategy)
    }
    fun toDto(): CarDto {
        return CarDto(position)
    }
}
