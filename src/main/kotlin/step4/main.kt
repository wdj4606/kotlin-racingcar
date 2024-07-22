package step4

import step4.domain.RaceGame
import step4.domain.RacingCar
import step4.view.InputView
import step4.view.ResultView

fun main() {
    val carNames = InputView.inputCarNames()
    val tryCount = InputView.inputTryCount()

    val cars = carNames.map { RacingCar(it) }

    val game = RaceGame(cars, tryCount)
    val winners = game.playGame()
    ResultView.printHistory(game.getRaceHistory())
    ResultView.printWinners(winners)
}
