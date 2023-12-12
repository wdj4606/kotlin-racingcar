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

    @Test
    fun `레이스 진행 확인1`() {
        val cars = listOf(Car("1"), Car("2"), Car("3"), Car("4"), Car("5"))
        val attempt = 5
        val race = Race(cars, attempt)
        race.run()
        race.participant.forEach { assertThat(it.position.size == 6).isTrue() }
    }

    @Test
    fun `레이스 진행 확인2`() {
        val cars = listOf(Car("1"), Car("2"), Car("3"), Car("4"), Car("5"), Car("6"), Car("7"), Car("8"), Car("9"), Car("10"))
        val attempt = 10
        val race = Race(cars, attempt)
        race.run()
        race.participant.forEach { assertThat(it.position.size == 11).isTrue() }
    }

    @Test
    fun `레이스 진행 확인3`() {
        val cars = listOf(Car("1"), Car("2"), Car("3"), Car("4"), Car("5"), Car("6"), Car("7"), Car("8"), Car("9"), Car("10"))
        val attempt = 5
        val race = Race(cars, attempt)
        race.run()
        race.participant.forEach { assertThat(it.position.size == 6).isTrue() }
    }
}
