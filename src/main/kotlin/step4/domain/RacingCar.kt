package step4.domain

import step4.domain.Randomizer.getRandom

class RacingCar(private val carName: String, var position: Int = INITIAL_POSITION) : Car(carName) {
    fun getCarName(): String {
        return carName
    }

    fun play() {
        if (isRunnable(getRandom())) position++
    }
}
