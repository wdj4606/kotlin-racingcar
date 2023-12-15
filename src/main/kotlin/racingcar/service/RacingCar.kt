package racingcar.service

class RacingCar(carNames: List<String>) {
    private val carList: MutableList<Car> = mutableListOf()

    init {
        for (carName in carNames) {
            carList.add(Car(carName))
        }
    }

    fun run(numberOfRound: Int) {
        repeat(numberOfRound) {
            carList.map { it.move() }
        }
    }

    fun getCarList(): List<Car> {
        return carList
    }

    fun getWinners(): List<Car> {
        val maxPosition = carList.maxOf { it.position }
        return carList.filter { it.position == maxPosition }
    }
}
