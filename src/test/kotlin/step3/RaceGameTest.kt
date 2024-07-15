package step3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RaceGameTest {
    @Test
    fun `차량의 동작 개수 확인`() {
        val initialCars = listOf(Car(), Car(), Car())
        val initialCarList = CarList(initialCars)
        val game = RaceGame(initialCarList, 5)

        val raceResults = game.runRace()
        assertEquals(5, raceResults.size)

        raceResults.forEach { carList ->
            assertEquals(initialCars.size, carList.carList.size)
        }
    }
}
