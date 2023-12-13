package step3

import step3.IOView.InputView
import step3.IOView.ResultView
import step3.domain.Car

object RacingCar {

    fun startRacing(carCount: Int, tryCount: Int) {
        // Car Array
        var carArray = Array(carCount) { Car() }

        println("실행 결과")
        for (i in 1..tryCount) {
            carArray = progress(carArray)
            ResultView.printProgress(carArray)
        }
    }

    private fun progress(carProgress: Array<Car>): Array<Car> {
        for (car in carProgress) {
            car.move()
        }
        return carProgress
    }

    fun play() {

        println("자동차 대수는 몇 대인가요?")
        val carCount = InputView.inputTryCount()
        println("시도할 회수는 몇 회인가요?")
        val tryCount = InputView.inputTryCount()

        startRacing(carCount, tryCount)
    }
}
