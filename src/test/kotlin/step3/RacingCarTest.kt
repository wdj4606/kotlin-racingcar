package step3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.service.Car
import racingcar.service.RacingCar
import racingcar.ui.ResultView

class RacingCarTest {

    @Test
    fun car() {
        repeat(100) {
            val car = Car()
            assertEquals(0, car.position)
            car.move()
            assertTrue(car.position == 0 || car.position == 1)
        }
    }

    @ParameterizedTest
    @CsvSource("0, 0", "3, 3", "5, 5", "0, 3", "3, 0", "3, 5", "5, 3")
    fun run(numberOfCar: Int, numberOfRound: Int) {
        val racingCar = RacingCar(numberOfCar)
        racingCar.run(numberOfRound)
        val carList = racingCar.getCarList()

        assertEquals(numberOfCar, carList.size)
        repeat(numberOfCar) {
            assert(carList[it].position >= 0)
            assert(numberOfRound >= carList[it].position)
        }
    }

    @Test
    fun printResult() {
        val carList = listOf(
            Car(),
            Car(),
            Car()
        )

        carList[0].position = 1
        carList[1].position = 2
        carList[2].position = 3

        // "-\n--\n---\n"
        val expected = """
            -
            --
            ---
            
        """.trimIndent()

        val actual = ResultView().getString(carList)
        assertEquals(expected, actual)
    }
}
