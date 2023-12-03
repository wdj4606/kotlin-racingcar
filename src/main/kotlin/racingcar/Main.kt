package racingcar

import racingcar.domain.Race
import racingcar.view.InputView
import racingcar.view.ResultView

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
