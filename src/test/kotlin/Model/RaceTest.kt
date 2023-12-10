package Model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun `레이스 정보 입력`() {
        val cars = listOf(Car("1"), Car("2"), Car("3"), Car("4"), Car("5"))
        val attempt = 5
        val race = Race(cars, attempt)
        race.participant.forEach { assertThat(it.id).isIn("1", "2", "3", "4", "5") }
        assertThat(race.attempt).isEqualTo(5)
    }
}
