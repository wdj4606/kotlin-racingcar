package racingcar.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.spyk
import io.mockk.verify

class MovableTest : FunSpec({

    test("move should increment position when isMovable returns true") {
        // given
        val movable = spyk<Movable>()
        val movableStrategy = spyk<RandomMovableStrategy>()
        movable.setMovableStrategy(movableStrategy)

        // Stubbing isMovable to return true
        every { movableStrategy.isMovable() } returns true

        // when
        movable.move()

        // then
        movable.position shouldBe 1
        verify(exactly = 1) { movableStrategy.isMovable() }
    }

    test("move should not increment position when isMovable returns false") {
        // given
        val movable = spyk<Movable>()
        val movableStrategy = spyk<RandomMovableStrategy>()
        movable.setMovableStrategy(movableStrategy)

        // Stubbing isMovable to return false
        every { movableStrategy.isMovable() } returns false

        // when
        movable.move()

        // then
        movable.position shouldBe 0
        verify(exactly = 1) { movableStrategy.isMovable() }
    }
})
