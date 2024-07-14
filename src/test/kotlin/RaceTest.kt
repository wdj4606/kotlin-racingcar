import CarRacing.CarEngine
import CarRacing.InputParameters
import CarRacing.Race
import CarRacing.RacingCar
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun `우등 자동차 경주 잘 진행되니?`() {
        val carNames: List<String> = listOf("pobi", "crong", "honux")
        val inputParameters = InputParameters(carNames, 5)
        val goodEngine = mockk<CarEngine>()
        every { goodEngine.isRunnable() } returns true
        val racingCars: List<RacingCar> = carNames.map { RacingCar(carName = it, carEngine = goodEngine) }
        val race = Race(racingCars)

        repeat(inputParameters.numberOfRace) {
            race.tryRace()
        }

        race.racingCars.forEach { racingCar ->
            Assertions.assertThat(racingCar.progress).isEqualTo(inputParameters.numberOfRace)
        }
    }

    @Test
    fun `열등 자동차 경주 잘 진행되니?`() {
        val carNames: List<String> = listOf("pobi", "crong", "honux")
        val inputParameters = InputParameters(carNames, 5)
        val badEngine = mockk<CarEngine>()
        every { badEngine.isRunnable() } returns false
        val racingCars: List<RacingCar> = carNames.map { RacingCar(carName = it, carEngine = badEngine) }
        val race = Race(racingCars)

        repeat(inputParameters.numberOfRace) {
            race.tryRace()
        }

        race.racingCars.forEach { racingCar ->
            Assertions.assertThat(racingCar.progress).isEqualTo(0)
        }
    }
}
