package racingcar.ui

import racingcar.service.Car

class ResultView {
    fun printResult(carList: List<Car>) {
        println("실행 결과")
        println(getResult(carList))
    }

    fun printWinners(winners: List<Car>) {
        println(getNameList(winners) + "가 최종 우승했습니다.")
    }

    private fun getResult(carList: List<Car>): String {
        val stringBuilder = StringBuilder()
        carList.forEach {
            stringBuilder.append(it.name)
            stringBuilder.append(" : ")
            stringBuilder.append("-".repeat(it.position))
            stringBuilder.append("\n")
        }
        return stringBuilder.toString()
    }

    private fun getNameList(carList: List<Car>): String {
        return carList.joinToString(", ") { it.name }
    }
}
