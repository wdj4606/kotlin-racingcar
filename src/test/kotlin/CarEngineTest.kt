import CarRacing.Domain.CarEngine
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarEngineTest {
    @Test
    fun `러너블 할 때`() {
        val carEngine = CarEngine(4)

        val runnable = carEngine.isRunnable()

        Assertions.assertThat(runnable).isEqualTo(true)
    }

    @Test
    fun `러너블 하지 않을 때`() {
        val carEngine = CarEngine(1)

        val runnable = carEngine.isRunnable()

        Assertions.assertThat(runnable).isEqualTo(false)
    }
}
