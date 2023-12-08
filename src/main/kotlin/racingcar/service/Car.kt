package racingcar.service

class Car() {
    var position: Int = 0

    fun move() {
        if (isMovable()) {
            position++
        }
    }

    private fun isMovable(): Boolean {
        return (Math.random() * 10).toInt() >= 4
    }
}
