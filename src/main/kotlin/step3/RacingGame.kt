package step3

object RacingGame {
    fun start() {
        val cars = Cars(InputView.inputCarCount())
        for (i in 1..InputView.inputTryCount()) {
            cars.goForward()
            ResultView.printResult(cars)
        }
    }
}
