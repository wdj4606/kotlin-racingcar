package racingcar.view

object InputView {
    fun getCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readlnOrNull()?.toIntOrNull() ?: 0
    }

    fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readlnOrNull()
            ?.replace(" ", "")
            ?.split(",")
            ?: listOf<String>()
    }

    fun getTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readlnOrNull()?.toIntOrNull() ?: 0
    }
}
