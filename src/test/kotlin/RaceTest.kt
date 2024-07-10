import CarRacing.InputParameters
import CarRacing.Race
import CarRacing.RaceErrorMessage
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class RaceTest {
    @Test
    fun `자동차 경주 잘 진행되니?`() {
        val inputParameters = InputParameters(3, 5)
        val race = Race(inputParameters)

        race.racingCars.forEach { racingCar ->
            Assertions.assertThat(racingCar.progress).isEqualTo(0)
        }

        race.tryRace()

        race.racingCars.forEach { racingCar ->
            Assertions.assertThat(racingCar.progress).isLessThanOrEqualTo(1)
        }

        race.tryRace()
        race.tryRace()
        race.tryRace()
        race.racingCars.forEach { racingCar ->
            Assertions.assertThat(racingCar.progress).isLessThanOrEqualTo(4)
        }
    }

    @Test
    fun `시도횟수 초과?`() {
        val inputParameters = InputParameters(3, 5)
        val race = Race(inputParameters)

        assertDoesNotThrow {
            race.tryRace()
            race.tryRace()
            race.tryRace()
            race.tryRace()
            race.tryRace()
        }
        Assertions.assertThatThrownBy {
            race.tryRace()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(RaceErrorMessage.OVER_TRY.toString())
    }
}
