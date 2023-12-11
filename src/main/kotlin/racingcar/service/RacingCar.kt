package racingcar.service

class RacingCar(numberOfCar: Int) {
    private val carList: MutableList<Car> = mutableListOf()

    init {
        repeat(numberOfCar) {
            carList.add(Car())
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
}
