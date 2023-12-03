package racingcar

import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class RaceTest {

    @Test
    fun `자동차 갯수 같은 지 확인`() {
        val race = Race(10)
        assertThat(race.cars.size).isEqualTo(10)
    }

    @Test
    fun `race를 할때 포함된 자동차가 동일하게 race하는지 확인`() {
        val carClass = mockk<Car>(relaxed = true)

        val race = Race(
            3,
            listOf(carClass, carClass, carClass)
        )
        race.race()

        verify(exactly = 3) { carClass.race() }
    }
}
