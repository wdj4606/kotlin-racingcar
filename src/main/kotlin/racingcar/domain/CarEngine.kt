package racingcar.domain

import kotlin.random.Random

class CarEngine {
    fun canMove(): Boolean {
        return Random.nextInt(MOVE_CHANCE_LIMIT) >= CAN_MOVE_READY
    }

    companion object {
        val CAN_MOVE_READY = 4
        val MOVE_CHANCE_LIMIT = 10
    }
}
