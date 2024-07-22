package step4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step4.domain.RaceGame
import step4.domain.RacingCar
import step4.domain.Randomizer
import step4.view.ResultView

class RaceGameTest {

    @Test
    fun `게임 테스트`() {
        val carNames = listOf("Peter", "Jin", "Makto")
        val tryCount = 5
        val cars = carNames.map { RacingCar(it) }
        val game = RaceGame(cars, tryCount)

        val winners = game.playGame()
        ResultView.printHistory(game.getRaceHistory())
        ResultView.printWinners(winners)

        assertThat(winners).isNotEmpty()
    }

    @Test
    fun `getRandom 함수 테스트`() {
        val randomNumber = Randomizer.getRandom()
        assertThat(randomNumber in Randomizer.RANDOM_MIN..Randomizer.RANDOM_MAX).isTrue()
    }

    @Test
    fun `4 이상일때 전진`() {
        val car = RacingCar("test")
        val location = car.position

        car.play(4)
        assertThat(car.position).isEqualTo(location + 1)
    }

    @Test
    fun `3 이하일때 정지`() {
        val car = RacingCar("test")
        val location = car.position

        car.play(3)
        assertThat(car.position).isEqualTo(location)
    }
}
