package racingcar.ui

import racingcar.service.Car

class ResultView {
    fun print(carList: List<Car>) {
        println("실행 결과")
        println(getString(carList))
    }

    fun getString(carList: List<Car>): String {
        val stringBuilder = StringBuilder()
        for (car in carList) {
            stringBuilder.append("-".repeat(car.position))
            stringBuilder.append("\n")
        }
        return stringBuilder.toString()
    }
}
