package racingcar.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.spyk

class CarTest : FunSpec({

    test("toDto should return CarDto with correct position") {
        // given
        val car = spyk<Car>()
        val movableStrategy = spyk<RandomMovableStrategy>()
        car.setMovableStrategy(movableStrategy)

        // Stubbing isMovable to return true (to increment position)
        every { movableStrategy.isMovable() } returns true
        car.move()

        // when
        val dto = car.toDto()

        // then
        dto.position shouldBe 1
    }

    test("toDto should return CarDto with correct position when position is not incremented") {
        // given
        val car = spyk<Car>()
        val movableStrategy = spyk<RandomMovableStrategy>()
        car.setMovableStrategy(movableStrategy)

        // Stubbing isMovable to return false (to not increment position)
        every { movableStrategy.isMovable() } returns false

        // when
        val dto = car.toDto()

        // then
        dto.position shouldBe 0
    }
})
