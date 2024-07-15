package step3

object InputView {
    private const val CAR_COUNT_INPUT_MESSAGE = "자동차 대수는 몇 대인가요?"
    private const val ROUND_INPUT_MESSAGE = "시도할 회수는 몇 회인가요?"

    fun getCarCount(): Int {
        println(CAR_COUNT_INPUT_MESSAGE)
        return readln().toInt()
    }

    fun getRoundCount(): Int {
        println(ROUND_INPUT_MESSAGE)
        return readln().toInt()
    }
}
