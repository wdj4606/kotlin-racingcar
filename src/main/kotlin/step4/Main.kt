package step4

import step4.Model.Race
import step4.View.InputView
import step4.View.ResultView

fun main() {
    val inputView = InputView()

    val participant = inputView.inputInfoOfCars()
    val race = Race(participant, inputView.inputNumberOfAttempts())
    race.run()

    val resultView = ResultView(race)
    resultView.printResult()
}
