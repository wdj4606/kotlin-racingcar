package racingcar.model

open class Movable() {
    private lateinit var movableStrategy: MovableStrategy
    var position: Int = 0
        private set

    fun move() {
        if (movableStrategy.isMovable()) {
            position++
        }
    }

    fun setMovableStrategy(movableStrategy: MovableStrategy) {
        this.movableStrategy = movableStrategy
    }
}
