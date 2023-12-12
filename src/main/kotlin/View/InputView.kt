package View

class InputView() {
    fun inputNumberOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        val numberOfCars = readln().toInt()
        require(numberOfCars > 0) { "자동차 대수는 1 이상이어야 합니다." }
        return numberOfCars
    }
    fun inputNumberOfAttempts(): Int {
        println("시도할 회수는 몇 회인가요?")
        val numberofAttempts = readln().toInt()
        require(numberofAttempts > 0) { "시도할 회수는 1 이상이어야 합니다." }
        return numberofAttempts
    }
}
