package racingcar.model

open class Movable() {
    private lateinit var movableStrategy: MovableStrategy
    private var _position: Int = 0

    val position: Int
        get() = _position

    fun move() {
        if (movableStrategy.isMovable()) {
            _position++
        }
    }

    fun setMovableStrategy(movableStrategy: MovableStrategy) {
        this.movableStrategy = movableStrategy
    }
}