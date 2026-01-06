package racingcar.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.spyk

class RandomMovableStrategyTest : BehaviorSpec({
    given("a RandomMovableStrategy with random value less than RANDOM_THRESHOLD") {
        (0..3).forEach { randomValue ->
            val mock = spyk<RandomMovableStrategy>()
            every { mock["generateRandomNumber"]() } returns randomValue

            `when`("isMovable is called with random number $randomValue") {
                val result = mock.isMovable()

                then("it should return false") {
                    result shouldBe false
                }
            }
        }
    }

    given("a RandomMovableStrategy with random value greater than or equal to RANDOM_THRESHOLD") {
        (4..9).forEach { randomValue ->
            val mock = spyk<RandomMovableStrategy>()
            every { mock["generateRandomNumber"]() } returns randomValue

            `when`("isMovable is called with random number $randomValue") {
                val result = mock.isMovable()

                then("it should return true") {
                    result shouldBe true
                }
            }
        }
    }
})
