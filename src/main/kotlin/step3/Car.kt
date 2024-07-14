package step3

class Car(var position : Int = Constants.INITIAL_POSITION) {

        fun move(random : Int) {
            if (random >= Constants.MOVE_CONDITION) {
                position++
            }
    }
}
