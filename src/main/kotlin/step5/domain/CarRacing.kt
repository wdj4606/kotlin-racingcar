package step5.domain

import step5.view.InputView
import step5.view.ResultView
import java.util.Random

class CarRacing(val carList: List<Car>) : List<Car> by carList {
    fun goRacing() {
        repeat(carList.size) {
            carList[it].move(Random().nextInt(9))
        }
    }

    fun getFinalResult(): String {
        val maxCount = carList.maxOf { it.movingCount }

        val firstCars = carList.filter { it.movingCount == maxCount }.map { it.name }

        return firstCars.joinToString(",")
    }
}

fun main() {
    val inputItem = InputView.getInputItem()

    val carNames = inputItem.carName.split(',')

    val carRacing = CarRacing(List(carNames.size) { i -> Car(carNames[i], 0) })

    repeat(inputItem.tryCount) {
        carRacing.goRacing()
        ResultView.showNowResult(carRacing.carList)
    }

    val firstCars = carRacing.getFinalResult()

    ResultView.showResult(firstCars)
}
