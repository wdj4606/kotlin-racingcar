package racingcar

import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    inputView.input()

    val race = Race(inputView.carNames)

    repeat(inputView.tryNum) {
        race.race()

        resultView.printCarPosition(race)
    }
    resultView.printWinner(race)
}
