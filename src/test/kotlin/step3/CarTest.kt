package step3

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class CarTest : DescribeSpec({

    describe("Car") {
        context("moveForward()를 호출하면") {
            it("distance가 1 증가한다.") {
                val car = Car()
                car.moveForward()
                car.distance shouldBe 1
            }
        }
    }
})
