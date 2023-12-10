package step3

object RacingGame {
    fun start() {
        val racingData: RacingData = InputView.inputRacingData()
        val cars = Cars(racingData.carCount)
        for (i in 1..racingData.tryCount) {
            cars.goForward()
            ResultView.printResult(cars)
        }
    }
}
