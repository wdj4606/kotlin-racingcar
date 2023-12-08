package step3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.service.Car
import racingcar.service.Racing
import racingcar.ui.ResultView

class RacingCarTest {

    @ParameterizedTest
    @CsvSource("0, 0", "3, 3", "5, 5", "0, 3", "3, 0", "3, 5", "5, 3")
    fun run(numberOfCar: Int, numberOfRound: Int) {
        val carList = Racing().run(numberOfCar, numberOfRound)

        assertEquals(numberOfCar, carList.size)
        for (car in carList) {
            assert(car.position >= 0)
            assert(numberOfRound >= car.position)
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
