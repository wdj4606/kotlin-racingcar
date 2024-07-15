package step4

import step4.ExceptionType.ERROR_CAR_NAME

class Car(val name: String, var position: Int = INITIAL_POSITION) {
    companion object {
        private const val MOVE_CONDITION = 4
        private const val INITIAL_POSITION = 0
        private const val NAME_SIZE_LIMIT = 5
    }

    init
    {
        require(name.length <= NAME_SIZE_LIMIT) { ERROR_CAR_NAME }
    }

    fun move(random: Int) {
        if (random >= MOVE_CONDITION) {
            position++
        }
    }
}
