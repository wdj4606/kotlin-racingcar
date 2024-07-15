import CarRacing.Domain.CarEngine
import CarRacing.Domain.RacingCar
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RacingCarTest {
    @Test
    fun `자동차 앞으로 잘 나가니?`() {
        val goodEngine = CarEngine(5)
        val racingCar = RacingCar(carEngine = goodEngine)

        racingCar.run()
        racingCar.run()
        racingCar.run()
        racingCar.run()

        Assertions.assertThat(racingCar.progress).isEqualTo(4)
    }

    @Test
    fun `이러면 자동차 앞으로 잘 안나가지?`() {
        val badEngine = CarEngine(0)
        val racingCar = RacingCar(carEngine = badEngine)

        racingCar.run()
        racingCar.run()
        racingCar.run()
        racingCar.run()

        Assertions.assertThat(racingCar.progress).isEqualTo(0)
    }
}
