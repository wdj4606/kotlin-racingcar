package step4.domain

object Randomizer {
    const val RANDOM_MAX = 9
    const val RANDOM_MIN = 0

    fun getRandom(): Int {
        return (RANDOM_MIN..RANDOM_MAX).random()
    }
}
