package racingcar

import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    inputView.input()

    val race = Race(inputView.carNum)

    for (i in 1..inputView.tryNum) {
        race.race()

        resultView.print(race)
    }
}
