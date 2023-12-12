package racingcar.model

abstract class Movable(
    private val movableStrategy: MovableStrategy
) {
    var position: Int = 0
        private set

    fun move() {
        if (movableStrategy.isMovable()) {
            position++
        }
    }
}
