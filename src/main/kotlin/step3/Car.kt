package step3

import kotlin.random.Random

class Car {

    var position: Int = START_POSITION
    fun move() {
        if (isMove()) position++
    }

    private fun isMove(): Boolean {
        return Random.nextInt(RANDOM_NUMBER) >= MOVABLE_NUMBER
    }

    companion object {
        private const val START_POSITION = 0
        private const val MOVABLE_NUMBER = 4
        private const val RANDOM_NUMBER = 9
    }
}
