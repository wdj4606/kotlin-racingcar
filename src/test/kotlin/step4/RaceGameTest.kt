package step4

import org.junit.jupiter.api.Test

class RaceGameTest {

    @Test
    fun `게임 테스트`() {
        val carNames = listOf("Peter", "Jin", "Makto")
        val tryCount = 5
        val cars = carNames.map { Car(it) }
        val game = RaceGame(cars, tryCount)

        val winners = game.playGame()
        ResultView.printHistory(game.getRaceHistory())
        ResultView.printWinners(winners)
    }
}
