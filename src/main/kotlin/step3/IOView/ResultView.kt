package step3.IOView

import step3.domain.Car

class ResultView {
    companion object {
        fun printProgress(carProgress: Array<Car>) {
            for (car in carProgress) {
                car.printProgress()
            }
            println()
        }
    }
}
