package step4.domain

class RacingCar(carName: String, var position: Int = INITIAL_POSITION) : Car(carName) {

    override fun play(random: Int) {
        if (isRunnable(random)) position++
    }
}
