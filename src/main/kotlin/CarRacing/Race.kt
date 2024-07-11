package CarRacing

enum class RaceErrorMessage(val message: String) {
    OVER_TRY("시도 횟수 초과");
}

data class Race(val numberOfCar: Int) {
    val racingCars: List<RacingCar> = List(numberOfCar) { RacingCar() }

    fun tryRace() {
        racingCars.forEach { racingCar -> racingCar.run() }
    }
}
