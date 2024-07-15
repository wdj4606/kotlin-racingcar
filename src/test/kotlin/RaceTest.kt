import CarRacing.CarEngine
import CarRacing.InputParameters
import CarRacing.Race
import CarRacing.RacingCar
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun `우등 자동차 경주 잘 진행되니?`() {
        val carNames: List<String> = listOf("pobi", "crong", "honux")
        val inputParameters = InputParameters(carNames, 5)
        val goodEngine = CarEngine(9)
        val racingCars: List<RacingCar> = carNames.map { RacingCar(carName = it, carEngine = goodEngine) }
        val race = Race(racingCars)

        repeat(inputParameters.numberOfRace) {
            race.tryRace()
        }

        Assertions.assertThat(allProgressAreSame(race.racingCars)).isEqualTo(true)
    }

    @Test
    fun `열등 자동차 경주 잘 진행되니?`() {
        val carNames: List<String> = listOf("pobi", "crong", "honux")
        val inputParameters = InputParameters(carNames, 5)
        val badEngine = CarEngine(1)
        val racingCars: List<RacingCar> = carNames.map { RacingCar(carName = it, carEngine = badEngine) }
        val race = Race(racingCars)

        repeat(inputParameters.numberOfRace) {
            race.tryRace()
        }

        Assertions.assertThat(allProgressAreSame(race.racingCars)).isEqualTo(true)
    }

    private fun allProgressAreSame(list: List<RacingCar>): Boolean {
        if (list.isEmpty()) return true
        val firstValue = list.first()
        return list.all { it.progress == firstValue.progress }
    }

    @Test
    fun `pobi가 우승 함?`() {
        val numberOfRace = 5
        val goodEngine = CarEngine(8)
        val badEngine = CarEngine(3)
        val car1 = RacingCar(carName = "pobi", carEngine = goodEngine)
        val car2 = RacingCar(carName = "crong", carEngine = badEngine)
        val car3 = RacingCar(carName = "honux", carEngine = badEngine)
        val racingCars: List<RacingCar> = listOf(car1, car2, car3)
        val race = Race(racingCars)

        repeat(numberOfRace) {
            race.tryRace()
        }

        val winners = race.getWinners()
        Assertions.assertThat(winners.size).isEqualTo(1)
        Assertions.assertThat(winners.first()).isEqualTo("pobi")
    }
}
