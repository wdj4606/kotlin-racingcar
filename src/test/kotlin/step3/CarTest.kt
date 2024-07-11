package step3

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `랜덤 숫자가 4 이상일 때 전진`() {
        val car = Car()
        val initialPosition = car.position

        repeat(1000) {
            car.move()
        }

        assertTrue(car.position > initialPosition)
    }

    @Test
    fun `랜덤 숫자가 4 미만일 때 전진하면 안됨`() {
        val car = Car()
        var moved = false

        repeat(1000) {
            val initialPosition = car.position
            car.move()
            if (car.position > initialPosition) {
                moved = true
            }
        }

        assertTrue(moved)
    }
}
