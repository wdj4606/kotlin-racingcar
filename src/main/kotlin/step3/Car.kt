package step3

class Car(var position: Int = INITIAL_POSITION) {
    companion object {
        private const val MOVE_CONDITION = 4
        private const val INITIAL_POSITION = 0
    }

    fun move(random: Int) {
        if (random >= MOVE_CONDITION) {
            position++
        }
    }
}
