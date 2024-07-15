package CarRacing.Domain

import kotlin.random.Random

object RandomGenerator {
    private const val RANDOM_STT = 0
    private const val RANDOM_END = 9
    fun run(): Int {
        return Random.nextInt(RANDOM_STT, RANDOM_END)
    }
}
