package racingcar.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.spyk

class RandomMovableStrategyTest : FunSpec({

    test("isMovable should return true when random value is greater than RANDOM_THRESHOLD") {
        (1..4).any {
            // given
            val mock = spyk<RandomMovableStrategy>(recordPrivateCalls = true)
            every { mock["generateRandomNumber"]() } returns it
            // when
            val result = mock.isMovable()
            result
        } shouldBe false
    }

    test("isMovable should return false when random value is greater than RANDOM_THRESHOLD") {
        (5..10).all {
            // given
            val mock = spyk<RandomMovableStrategy>(recordPrivateCalls = true)
            every { mock["generateRandomNumber"]() } returns it
            // when
            val result = mock.isMovable()
            result
        } shouldBe true
    }
})
