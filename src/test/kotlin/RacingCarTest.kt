import CarRacing.CarEngine
import CarRacing.RacingCar
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RacingCarTest {
    @Test
    fun `자동차 앞으로 잘 나가니?`() {
        val goodEngine = mockk<CarEngine>()
        every { goodEngine.isRunnable() } returns true
        val racingCar = RacingCar(carEngine = goodEngine)

        racingCar.run()
        racingCar.run()
        racingCar.run()
        racingCar.run()

        Assertions.assertThat(racingCar.progress).isEqualTo(4)
    }

    @Test
    fun `이러면 자동차 앞으로 잘 안나가지?`() {
        val badEngine = mockk<CarEngine>()
        every { badEngine.isRunnable() } returns false
        val racingCar = RacingCar(carEngine = badEngine)

        racingCar.run()
        racingCar.run()
        racingCar.run()
        racingCar.run()

        Assertions.assertThat(racingCar.progress).isEqualTo(0)
    }
}
