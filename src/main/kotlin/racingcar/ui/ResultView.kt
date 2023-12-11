package racingcar.ui

import racingcar.service.Car

class ResultView {
    fun print(carList: List<Car>) {
        println("실행 결과")
        println(getString(carList))
    }

    fun getString(carList: List<Car>): String {
        val stringBuilder = StringBuilder()
        repeat(carList.size) {
            stringBuilder.append("-".repeat(carList[it].position))
            stringBuilder.append("\n")
        }
        return stringBuilder.toString()
    }
}
