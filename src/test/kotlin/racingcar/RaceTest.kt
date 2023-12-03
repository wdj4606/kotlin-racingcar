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
        val carNames = listOf("a", "b", "c", "d")
        val race = Race(carNames)
        assertThat(race.cars.size).isEqualTo(4)
        assertThat(race.cars.all { carNames.contains(it.name) }).isTrue()
    }

    @Test
    fun `race를 할때 포함된 자동차가 동일하게 race하는지 확인`() {
        val carClass = mockk<Car>(relaxed = true)

        val race = Race(
            listOf("hello", "world", "space"),
            listOf(carClass, carClass, carClass)
        )
        race.race()

        verify(exactly = 3) { carClass.race() }
    }
}
