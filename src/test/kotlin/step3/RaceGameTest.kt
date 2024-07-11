package step3

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RaceGameTest {

    @Test
    fun `경주 게임이 올바르게 실행되는지 확인`() {
        val cars = List(3) { Car() }
        val game = RaceGame(cars, 5)

        game.runRace()

        cars.forEach { car ->
            assertTrue(car.position > 0)
        }
    }
}
