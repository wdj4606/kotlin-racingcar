package racingcar

import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkAll
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import kotlin.random.Random

class CarEngineTest {

    @BeforeEach
    fun setUp() {
        unmockkAll()
    }

    @RepeatedTest(30)
    fun `자동차가 움직일 때`() {
        mockkObject(Random.Default)
        every { Random.nextInt(10) } returns 8
        val carEngine = CarEngine()
        assertThat(carEngine.canMove()).isTrue()
    }

    @RepeatedTest(30)
    fun `자동차가 움직이지 않을 때`() {
        mockkObject(Random.Default)
        every { Random.nextInt(any()) } returns 2
        val carEngine = CarEngine()
        assertThat(carEngine.canMove()).isFalse()
    }
}
