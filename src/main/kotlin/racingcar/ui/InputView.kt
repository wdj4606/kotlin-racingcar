package racingcar.ui

class InputView {
    fun inputNumberOfCar(): Int {
        println("자동차 대수는 몇 대 인가요?")
        val value = readln()
        return value.toInt()
    }

    fun inputNumberOfRound(): Int {
        println("시도할 회수는 몇 회 인가요?")
        val value = readln()
        return value.toInt()
    }
}
