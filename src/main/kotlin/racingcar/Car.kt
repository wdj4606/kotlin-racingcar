package racingcar

class Car(
    var position: Int = DEFAULT_POSITION,
    private var engine: CarEngine = CarEngine()
) {

    fun race() {
        if (engine.canMove()) move()
    }

    private fun move() {
        position++
    }

    companion object {
        val DEFAULT_POSITION = 0
    }
}
