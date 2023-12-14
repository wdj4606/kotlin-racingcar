package step3.IOView

import step3.domain.Car

class ResultView {
    companion object {
        fun printCarProgress(car: Car) {
            for (i in 0 until car.getProgress()) {
                print("-")
            }
            println()
        }
    }
}
