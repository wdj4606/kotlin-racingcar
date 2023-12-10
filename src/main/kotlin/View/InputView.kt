package View

class InputView() {
    private var numberOfCars: Int = 0
    private var numberofAttempts: Int = 0

    fun inputNumberOfCars() {
        println("자동차 대수는 몇 대인가요?")
        numberOfCars = readln().toInt()
        require(numberOfCars > 0) { "자동차 대수는 1 이상이어야 합니다." }
    }
    fun inputNumberOfAttempts() {
        println("시도할 회수는 몇 회인가요?")
        numberofAttempts = readln().toInt()
        require(numberofAttempts > 0) { "시도할 회수는 1 이상이어야 합니다." }
    }

    fun getNumberOfCars(): Int {
        return numberOfCars
    }

    fun getNumberOfAttempts(): Int {
        return numberofAttempts
    }
}
