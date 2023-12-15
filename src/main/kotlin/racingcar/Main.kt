package racingcar

import racingcar.service.RacingCar
import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {

    val inputView = InputView()

    val carNames = inputView.inputNameOfCars()
    val racingCar = RacingCar(carNames)

    val numberOfRound = inputView.inputNumberOfRound()
    racingCar.run(numberOfRound)

    val resultView = ResultView()
    resultView.printResult(racingCar.getCarList())
    resultView.printWinners(racingCar.getWinners())
}
