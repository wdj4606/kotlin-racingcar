package racingcar

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차 이동 테스트 갈 수 있을 때`() {
        val engine = mockk<CarEngine>()
        every { engine.canMove() } returns true
        val car = Car(engine = engine)

        for (i in 0..99) {
            car.race()
        }

        assertThat(car.position).isEqualTo(101)
    }
    @Test
    fun `자동차 이동 테스트 갈 수 없을 때`() {
        val engine = mockk<CarEngine>()
        every { engine.canMove() } returns false
        val car = Car(engine = engine)

        for (i in 0..99) {
            car.race()
        }

        assertThat(car.position).isEqualTo(1)
    }
}
