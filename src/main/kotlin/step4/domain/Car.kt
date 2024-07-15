package step4.domain

import step4.ExceptionType.ERROR_CAR_NAME

open class Car(protected val name: String) {
    init {
        require(name.length <= NAME_SIZE_LIMIT) { ERROR_CAR_NAME }
    }

    protected fun isRunnable(random: Int): Boolean {
        return random >= MOVE_CONDITION
    }

    companion object {
        const val MOVE_CONDITION = 4
        const val NAME_SIZE_LIMIT = 5
        const val INITIAL_POSITION = 0
    }
}
