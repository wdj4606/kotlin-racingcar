package racingcar.ui

class InputView {
    fun inputNameOfCars(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분).")
        val value = readln()
        return value.split(SEPARATOR)
    }

    fun inputNumberOfRound(): Int {
        println("시도할 회수는 몇 회 인가요?")
        val value = readln()
        return value.toInt()
    }

    companion object {
        const val SEPARATOR = ","
    }
}
