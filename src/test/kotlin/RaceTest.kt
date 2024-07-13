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
        val racingCar1 = RacingCar(carEngine = goodEngine)
        val racingCar2 = RacingCar(carEngine = goodEngine)
        val racingCar3 = RacingCar(carEngine = goodEngine)
        val racingCars: List<RacingCar> = listOf(racingCar1, racingCar2, racingCar3)
        val race = Race(racingCars = racingCars)

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
        val racingCar1 = RacingCar(carEngine = badEngine)
        val racingCar2 = RacingCar(carEngine = badEngine)
        val racingCar3 = RacingCar(carEngine = badEngine)
        val racingCars: List<RacingCar> = listOf(racingCar1, racingCar2, racingCar3)
        val race = Race(inputParameters.carNames, racingCars)

        repeat(inputParameters.numberOfRace) {
            race.tryRace()
        }

        race.racingCars.forEach { racingCar ->
            Assertions.assertThat(racingCar.progress).isEqualTo(0)
        }
    }
}
