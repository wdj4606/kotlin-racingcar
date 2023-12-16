package step4

import step4.domain.Race
import step4.view.InputView
import step4.view.ResultView

fun main() {
    val inputView = InputView()

    val participant = inputView.inputInfoOfCars()
    val race = Race(participant, inputView.inputNumberOfAttempts())
    race.run()

    val resultView = ResultView(race)
    resultView.printResult()
}
