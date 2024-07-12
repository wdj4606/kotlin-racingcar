import CarRacing.InputParameters
import CarRacing.Race
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun `자동차 경주 잘 진행되니?`() {
        val inputParameters = InputParameters(3, 5)
        val race = Race(inputParameters.numberOfCar)

        repeat(inputParameters.numberOfRace) {
            race.tryRace()
        }

        race.racingCars.forEach { racingCar ->
            Assertions.assertThat(racingCar.progress).isLessThanOrEqualTo(inputParameters.numberOfRace)
        }
    }
}
