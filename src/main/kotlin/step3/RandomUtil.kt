package step3

import kotlin.random.Random

object RandomUtil {
    fun getRandomNumber(): Int {
        return Random.nextInt(0, 10)
    }
}
