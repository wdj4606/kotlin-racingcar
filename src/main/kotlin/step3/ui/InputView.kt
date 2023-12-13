package step3.ui

object InputView {

    var carNumbers: Int = 0
    var tryNumbers: Int = 0

    fun inputCarNumbers() {
        println("자동차 대수는 몇 대 인가요?")
        carNumbers = this.toIntOrThrow(readln())
    }

    fun inputTryNumbers() {
        println("시도할 회수는 몇 회 인가요?")
        tryNumbers = this.toIntOrThrow(readln())
    }

    private fun toIntOrThrow(input: String): Int {
        return input.toIntOrNull() ?: throw IllegalArgumentException("숫자가 아닙니다.")
    }
}
