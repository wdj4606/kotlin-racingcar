package racingcar

import racingcar.service.RacingCar
import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {

    val inputView = InputView()

    val numberOfCar = inputView.inputNumberOfCar()
    val racingCar = RacingCar(numberOfCar)

    val numberOfRound = inputView.inputNumberOfRound()
    racingCar.run(numberOfRound)

    val resultView = ResultView()
    resultView.print(racingCar.getCarList())
}
