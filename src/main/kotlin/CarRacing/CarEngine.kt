package CarRacing

import kotlin.random.Random

class CarEngine {
    companion object {
        private const val RANDOM_STT = 0
        private const val RANDOM_END = 9
    }

    fun isRunnable(): Boolean {
        val random = Random.nextInt(RANDOM_STT, RANDOM_END)
        return random >= THRESHOLD_VALUE
    }
}
