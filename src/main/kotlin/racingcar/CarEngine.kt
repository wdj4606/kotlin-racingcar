package racingcar

import kotlin.random.Random

class CarEngine {
    fun canMove(): Boolean {
        return Random.nextInt(10) >= CAN_MOVE_READY
    }

    companion object {
        val CAN_MOVE_READY = 4
    }
}
