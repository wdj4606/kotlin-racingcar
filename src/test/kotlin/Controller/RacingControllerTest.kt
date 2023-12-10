package Controller

import Model.Car
import Model.Race
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingControllerTest {
    @Test
    fun `레이스 로그 초기화 확인`() {
        val cars = listOf(Car("1"), Car("2"), Car("3"), Car("4"), Car("5"))
        val attempt = 1
        val race = Race(cars, attempt)
        val racingController = RacingController(race)
        assertThat(racingController.raceLog.size == 0).isTrue()
        racingController.run()
        racingController.raceLog[0].forEach { assertThat(it == 0).isTrue() } // 시작 위치 0으로 초기화 되었는지 확인
        assertThat(racingController.raceLog.size == 2).isTrue()
    }

    @Test
    fun `레이스 진행 확인1`() {
        val cars = listOf(Car("1"), Car("2"), Car("3"), Car("4"), Car("5"))
        val attempt = 5
        val race = Race(cars, attempt)
        val racingController = RacingController(race)
        assertThat(racingController.raceLog.size == 0).isTrue()
        racingController.run()
        racingController.raceLog.forEach { assertThat(it.size == 5).isTrue() }
        assertThat(racingController.raceLog.size == 6).isTrue()
    }

    @Test
    fun `레이스 진행 확인2`() {
        val cars = listOf(Car("1"), Car("2"), Car("3"), Car("4"), Car("5"), Car("6"), Car("7"), Car("8"), Car("9"), Car("10"))
        val attempt = 10
        val race = Race(cars, attempt)
        val racingController = RacingController(race)
        racingController.run()
        racingController.raceLog.forEach { assertThat(it.size == 10).isTrue() }
        assertThat(racingController.raceLog.size == 11).isTrue()
    }

    @Test
    fun `레이스 진행 확인3`() {
        val cars = listOf(Car("1"), Car("2"), Car("3"), Car("4"), Car("5"), Car("6"), Car("7"), Car("8"), Car("9"), Car("10"))
        val attempt = 5
        val race = Race(cars, attempt)
        val racingController = RacingController(race)
        racingController.run()
        racingController.raceLog.forEach { assertThat(it.size == 10).isTrue() }
        assertThat(racingController.raceLog.size == 6).isTrue()
    }
}
