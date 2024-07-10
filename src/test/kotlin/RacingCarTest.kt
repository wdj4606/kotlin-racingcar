import CarRacing.RacingCar
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RacingCarTest {
    @Test
    fun `자동차 앞으로 잘 나가니?`() {
        val racingCar = RacingCar()
        Assertions.assertThat(racingCar.progress).isEqualTo(0)

        racingCar.run()
        Assertions.assertThat(racingCar.progress).isLessThanOrEqualTo(1)

        racingCar.run()
        racingCar.run()
        racingCar.run()
        Assertions.assertThat(racingCar.progress).isLessThanOrEqualTo(4)
    }
}
