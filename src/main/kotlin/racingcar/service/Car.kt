package racingcar.service

import kotlin.random.Random

class Car() {
    var position: Int = RacingRule.START_POSITION

    fun move() {
        if (isMovable()) {
            position++
        }
    }

    private fun isMovable(): Boolean {
        return Random.nextInt(RacingRule.MAX_RANDOM_NUMBER) >= RacingRule.ENABLE_TO_MOVE
    }
}
