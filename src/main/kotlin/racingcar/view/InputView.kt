package racingcar.view

object InputView {
    fun getCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readlnOrNull()?.toIntOrNull() ?: 0
    }

    fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readlnOrNull()
            ?.trim()
            ?.split(",")
            ?: throw IllegalArgumentException("유효하지 않은 자동차 이름 입력입니다. 이름은 쉼표(,)로 구분되어야 합니다.")
    }

    fun getTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")

        return readlnOrNull()
            ?.run {
                toIntOrNull()?.takeIf { it > 0 }
            }
            ?: throw IllegalArgumentException("유효하지 않은 시도 횟수 입력입니다. 자연수로 입력되어야 합니다.")
    }
}
