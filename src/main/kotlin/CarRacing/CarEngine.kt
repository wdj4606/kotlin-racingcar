package CarRacing

import kotlin.random.Random

const val RANDOM_STT = 0
const val RANDOM_END = 9

class CarEngine {
    fun isRunnable(): Boolean {
        val random = Random.nextInt(RANDOM_STT, RANDOM_END)
        return random >= THRESHOLD_VALUE
    }
}
