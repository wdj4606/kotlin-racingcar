package step3

import kotlin.random.Random

object RandomUtil {

    fun isGoForward(): Boolean {
        return getRandomNumber() >= 4
    }
    private fun getRandomNumber(): Int {
        return Random.nextInt(0, 10)
    }
}
