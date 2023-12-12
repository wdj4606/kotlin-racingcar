package step3

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject

internal class CarTest : DescribeSpec({

    describe("Car") {
        context("moveForward()를 호출하면") {
            it("distance가 1 증가한다.") {
                mockkObject(RandomUtil)
                every { RandomUtil.getRandomNumber() } returns 5

                val car = Car()
                car.moveForward()
                car.distance shouldBe 1
            }
        }
    }
})
