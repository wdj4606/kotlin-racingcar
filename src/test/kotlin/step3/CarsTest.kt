package step3

import io.kotest.core.spec.style.DescribeSpec
import io.mockk.mockkObject
import io.mockk.verify

class CarsTest : DescribeSpec({

    describe("Cars") {

        context("goForward()를 호출하면") {

            it("자동차 메서드가 호출된다.") {
                mockkObject(RandomUtil)

                val cars = Cars(3)
                cars.goForward()

                verify(exactly = 3) { Car().moveForward() }
            }
        }
    }
})
