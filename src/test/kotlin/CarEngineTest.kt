import CarRacing.CarEngine
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarEngineTest {
    @Test
    fun `러너블 할 때`() {
        val carEngine = mockk<CarEngine>()
        every { carEngine.isRunnable() } returns true

        val runnable = carEngine.isRunnable()

        Assertions.assertThat(runnable).isEqualTo(true)
    }

    @Test
    fun `러너블 하지 않을 때`() {
        val carEngine = mockk<CarEngine>()
        every { carEngine.isRunnable() } returns false

        val runnable = carEngine.isRunnable()

        Assertions.assertThat(runnable).isEqualTo(false)
    }
}
