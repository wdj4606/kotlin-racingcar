package step3

class Car {
    var position: Int = 0

    fun move() {
        if ((0..9).random() >= 4) {
            position++
        }
    }
}
