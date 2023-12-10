package step3

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import step2.Calculator.Calculator

class CarKtTest {

    @Test
    fun `자동차 입력 테스트`() {
        System.setIn("3\n".byteInputStream())
        assertEquals(3, Input.readCarCount())
    }

    @Test
    fun `실행횟수 입력 테스트`() {
        System.setIn("5\n".byteInputStream())
        assertEquals(5, Input.readTryCount())
    }


    @Test
    fun `자동차 이동`() {
        val car = Car()
        car.move()
        assertTrue(car.position == 0 || car.position == 1)
    }

    @Test
    fun `자동자 경주`() {
        val cars = List(3) { Car() }
        val game = RacingGame(cars)
        game.playRound()

        assertTrue(cars.all { it.position == 0 || it.position == 1 })
    }
}