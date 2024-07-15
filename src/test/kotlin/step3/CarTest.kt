package step3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `랜덤 숫자가 4 이상일 때 자동차가 전진한다`() {
        val car = Car()
        val initialPosition = car.position

        car.move(4)
        car.move(5)
        car.move(6)
        car.move(7)
        car.move(8)
        car.move(9)

        assertEquals(initialPosition + 6, car.position)
    }

    @Test
    fun `랜덤 숫자가 4 미만일 때 자동차가 전진하지 않는다`() {
        val car = Car()
        val initialPosition = car.position

        car.move(0)
        car.move(1)
        car.move(2)
        car.move(3)

        assertEquals(initialPosition, car.position)
    }
}
