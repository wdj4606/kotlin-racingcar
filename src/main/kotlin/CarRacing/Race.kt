package CarRacing

enum class RaceErrorMessage(val message: String) {
    OVER_TRY("시도 횟수 초과");
}

data class Race(val inputParameters: InputParameters) {
    val racingCars: List<RacingCar> = List(inputParameters.numberOfCar) { RacingCar() }
    private var currentTryCount: Int = 0

    fun tryRace() {
        require(inputParameters.numberOfRace > currentTryCount) { RaceErrorMessage.OVER_TRY }
        currentTryCount += 1
        racingCars.forEach { racingCar -> racingCar.run() }
    }
}
