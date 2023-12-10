package step5.view

import step5.domain.Car
import step5.domain.InputItem

object InputView {
    fun getInputItem(): InputItem {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carName = readln()

        println("시도 횟수는?")
        val tryCount = readln().toInt()

        return InputItem(carName, tryCount)
    }
}

object ResultView {
    fun showNowResult(carList: List<Car>) {
        for (car in carList) {
            println(car.name + " : " + "-".repeat(car.movingCount))
        }

        println()
    }

    fun showResult(firstCars: String) {
        println(firstCars + "가 최종 우승했습니다.")
    }
}
