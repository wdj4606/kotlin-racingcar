package step3

private const val MOVE_CONDITION = 4
private const val INITIAL_POSITION = 0

class Car(var position : Int = INITIAL_POSITION) {

        fun move(random : Int) {
            if (random >= MOVE_CONDITION) {
                position++
            }
    }
}
