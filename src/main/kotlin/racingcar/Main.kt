package racingcar

import racingcar.service.Car
import racingcar.service.RacingCar
import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {

    val inputView = InputView()

    val carNames = inputView.inputNameOfCars()
    val carList: List<Car> = carNames.map { Car(it) }
    val racingCar = RacingCar(carList)

    val numberOfRound = inputView.inputNumberOfRound()
    racingCar.run(numberOfRound)

    val resultView = ResultView()
    resultView.printResult(racingCar.carList)
    resultView.printWinners(racingCar.getWinners())
}
