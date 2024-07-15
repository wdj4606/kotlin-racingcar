package step4

fun main() {
    val carNames = InputView.inputCarNames()
    val tryCount = InputView.inputTryCount()

    val cars = carNames.map { Car(it) }

    val game = RaceGame(cars, tryCount)
    val winners = game.playGame()
    ResultView.printHistory(game.getRaceHistory())
    ResultView.printWinners(winners)
}
