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
    fun carMoveTest() {
        repeat(100) {
            val car = Car("test")
            assertEquals(car.name, "test")
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
    fun racingTest(input: String, numberOfRound: Int) {
        val carNames = input.split(", ")
        val carList = carNames.map { Car(it) }
        val racingCar = RacingCar(carList)
        racingCar.run(numberOfRound)
        val resultCarList = racingCar.carList

        assertEquals(carNames.size, resultCarList.size)
        resultCarList.forEach {
            assert(it.position >= 0)
            assert(numberOfRound >= it.position)
        }
    }

    @Test
    fun winnerTest() {
        val numberOfCar = 3
        val numberOfRound = 5
        val carNames = "a, b, c"
        val carList = carNames.split(", ").map { Car(it) }
        val racingCar = RacingCar(carList)

        assert(racingCar.carList.size == numberOfCar)

        racingCar.run(numberOfRound)
        val resultCarList = racingCar.carList
        val winners = racingCar.getWinners()

        assert(resultCarList.size == numberOfCar)
        assert(winners.size > 0 && winners.size <= numberOfCar)

        val aPostion = resultCarList[0].position
        val bPostion = resultCarList[1].position
        val cPostion = resultCarList[2].position
        val max = maxOf(aPostion, bPostion, cPostion)

        winners.forEach {
            assert(it.position == resultCarList.maxOf { it.position })
            assert(numberOfRound >= it.position)
            assert(it.position == max)
        }
    }
}
