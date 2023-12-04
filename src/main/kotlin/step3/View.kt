package step3

object InputView {
    fun getInputItem(): InputItem {
        println("자동차 대수는 몇 대인가요?")
        val carCount = readln().toInt()

        println("시도 횟수는?")
        val tryCount = readln().toInt()

        return InputItem(carCount, tryCount)
    }
}

object ResultView {
    fun showResult(carList: MutableList<String>) {
        for (car in carList) {
            println(car)
        }

        println()
    }
}
