package step4

fun main() {
    val carNames = InputView.inputCarNames()

    val tryCount = InputView.inputTryCount()

    val game = RaceGame(carNames, tryCount)
    val winners = game.playGame()

    ResultView.printWinners(winners)
}