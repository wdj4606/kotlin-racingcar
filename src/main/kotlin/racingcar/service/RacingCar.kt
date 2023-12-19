package racingcar.service

class RacingCar(val carList: List<Car>) {
    fun run(numberOfRound: Int) {
        repeat(numberOfRound) {
            carList.map { it.move() }
        }
    }

    fun getWinners(): List<Car> {
        val maxPosition = carList.maxOf { it.position }
        return carList.filter { it.position == maxPosition }
    }
}
