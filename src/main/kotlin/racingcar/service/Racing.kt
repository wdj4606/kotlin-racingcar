package racingcar.service

import racingcar.ui.InputView
import racingcar.ui.ResultView

class Racing {
    fun start() {
        val inputView = InputView()
        val numberOfCar = inputView.inputNumberOfCar()
        val numberOfRound = inputView.inputNumberOfRound()
        val carList = run(numberOfCar, numberOfRound)
        printResult(carList)
    }

    fun run(numberOfCar: Int, numberOfRound: Int): List<Car> {
        val carList = mutableListOf<Car>()
        for (i in 1..numberOfCar) {
            carList.add(Car())
        }

        for (i in 1..numberOfRound) {
            carList.map { it.move() }
        }

        return carList
    }

    fun printResult(carList: List<Car>) {
        val resultView = ResultView()
        resultView.print(carList)
    }
}
