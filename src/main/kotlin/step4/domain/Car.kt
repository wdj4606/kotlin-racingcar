package step4.domain

import step4.ExceptionType.ERROR_CAR_NAME

abstract class Car(val name: String) {
    init {
        require(name.length <= NAME_SIZE_LIMIT) { ERROR_CAR_NAME }
    }

    protected fun isRunnable(number: Int): Boolean {
        return number >= MOVE_CONDITION
    }

    abstract fun play(random: Int)

    companion object {
        const val MOVE_CONDITION = 4
        const val NAME_SIZE_LIMIT = 5
        const val INITIAL_POSITION = 0
    }
}
