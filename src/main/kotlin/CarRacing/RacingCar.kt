package CarRacing

import kotlin.random.Random

data class RacingCar(var progress: Int = 0) {
    fun run() {
        val random = Random.nextInt(0, 9)
        if (random >= 4)
            progress += 1
    }
}
