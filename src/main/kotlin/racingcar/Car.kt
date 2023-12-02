package racingcar

class Car(
    var position: Int = 1,
    private var engine: CarEngine = CarEngine()
) {

    fun race() {
        if (engine.canMove()) move()
    }

    private fun move() {
        position++
    }
}
