package racingcar.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CarTest : FunSpec({

    test("toDto should return CarDto with correct position") {
        // given
        val alwaysMoveStrategy = MovableStrategy { true }
        val car = Car(alwaysMoveStrategy)
        car.move()
        // when
        val dto = car.toDto()

        // then
        dto.position shouldBe 1
    }

    test("toDto should return CarDto with correct position when position is not incremented") {
        // given
        val neverMoveStrategy = MovableStrategy { false }
        val car = Car(neverMoveStrategy)
        car.move()
        // when
        val dto = car.toDto()

        // then
        dto.position shouldBe 0
    }
})
