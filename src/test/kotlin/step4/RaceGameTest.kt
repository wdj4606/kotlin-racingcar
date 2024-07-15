package step4

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import step4.domain.Car
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
    }

    @Test
    fun `car 생성 시 이름 유효성 검사`() {
        val invalidName = "5글자가넘는이름"
        val validName = "12345"

        assertThrows<IllegalArgumentException> {
            Car(invalidName)
        }

        Car(validName)
    }

    @Test
    fun `getRandom 함수 테스트`() {
        val randomNumber = Randomizer.getRandom()

        assert(randomNumber in Randomizer.RANDOM_MIN..Randomizer.RANDOM_MAX) {
            "생성된 숫자 $randomNumber 는 범위를 벗어났습니다. " +
                "[${Randomizer.RANDOM_MIN}, ${Randomizer.RANDOM_MAX}]"
        }
    }
}
