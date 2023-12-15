package step3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.service.Car
import racingcar.service.RacingCar

class RacingCarTest {

    @Test
    fun car() {
        repeat(100) {
            val car = Car("test")
            assertEquals(0, car.position)
            car.move()
            assertTrue(car.position == 0 || car.position == 1)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "'a', 1",
        "'a,b', 1",
        "'a,b,c', 1",
        "'a', 2",
        "'a,b', 2",
        "'a,b,c', 2",
        "'a', 3",
        "'a,b', 3",
        "'a,b,c', 3"
    )
    fun run(input: String, numberOfRound: Int) {
        val carNames = input.split(", ")
        val racingCar = RacingCar(carNames)
        racingCar.run(numberOfRound)
        val carList = racingCar.getCarList()
        val winners = racingCar.getWinners()

        assertEquals(carNames.size, carList.size)
        carList.forEach {
            assert(it.position >= 0)
            assert(numberOfRound >= it.position)
        }
        winners.forEach {
            assert(it.position == carList.maxOf { it.position })
            assert(numberOfRound >= it.position)
        }
    }
}
