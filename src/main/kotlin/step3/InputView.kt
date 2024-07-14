package step3

object InputView {

    fun getCarCount(): Int {
        println(Constants.CAR_COUNT_INPUT_MESSAGE)
        return readln().toInt()
    }

    fun getRoundCount(): Int {
        println(Constants.ROUND_INPUT_MESSAGE)
        return readln().toInt()
    }
}
