package step3

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject

class CarsTest : DescribeSpec({

    describe("Cars") {

        context("moveForward()를 호출하면") {

            it("내부의 자동차가 전진한다.") {
                mockkObject(RandomUtil)
                every { RandomUtil.isGoForward() } returns true

                val cars = Cars(3)
                cars.goForward()
                cars.cars.forEach { it.distance shouldBe 1 }
            }
        }
    }
})
