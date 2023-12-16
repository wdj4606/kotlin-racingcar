package step4.util

import kotlin.random.Random

object RandomUtil {
    fun getRandomNumber(): Int {
        return Random.nextInt(10)
    }
}
