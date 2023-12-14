package step3

import step3.IOView.ResultView
import step3.domain.Car

class CarLists(
    private val carList: List<Car>
) {
    fun progress() {
        for (car in carList) {
            val random = (Math.random() * 10).toInt()
            car.move(random)
        }
    }
    fun printProgress() {
        for (car in carList) {
            ResultView.printCarProgress(car)
        }
        println()
    }
}
