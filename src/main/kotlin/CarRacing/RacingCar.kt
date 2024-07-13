package CarRacing

import kotlin.random.Random

const val INITIAL_PROGRESS = 0
const val RANDOM_STT = 0
const val RANDOM_END = 9
const val THRESHOLD_VALUE = 4

class RacingCar(var progress: Int = INITIAL_PROGRESS) {
    fun run() {
        val random = Random.nextInt(RANDOM_STT, RANDOM_END)
        if (random >= THRESHOLD_VALUE)
            progress += 1
    }
}
