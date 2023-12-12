package racingcar.model

import kotlin.random.Random

class RandomMovableStrategy : MovableStrategy {
    companion object {
        const val RANDOM_BOUND = 10
        const val RANDOM_THRESHOLD = 4
    }

    private fun generateRandomNumber(): Int {
        return Random.nextInt(RANDOM_BOUND)
    }

    private val randomIterator: Iterator<Int> = generateSequence(::generateRandomNumber).iterator()

    override fun isMovable(): Boolean {
        return randomIterator.next() > RANDOM_THRESHOLD
    }
}
