package racingcar.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarTest : BehaviorSpec({

    given("a car with alwaysMoveStrategy") {
        val alwaysMoveStrategy = MovableStrategy { true }
        val car = Car("test-car", alwaysMoveStrategy)

        `when`("the car is moved") {
            car.move()

            then("toDto should return CarDto with correct position") {
                val dto = car.toDto()
                dto.position shouldBe 1
            }
        }
    }

    given("a car with neverMoveStrategy") {
        val neverMoveStrategy = MovableStrategy { false }
        val car = Car("test-car", neverMoveStrategy)

        `when`("the car is moved") {
            car.move()

            then("toDto should return CarDto with correct position when position is not incremented") {
                val dto = car.toDto()
                dto.position shouldBe 0
            }
        }
    }
})
