package CarRacing

enum class RaceErrorMessage(val message: String) {
    OVER_TRY("시도 횟수 초과");
}

class Race(carNames: List<String> = List(3) { "pobi" }, val racingCars: List<RacingCar> = carNames.map { RacingCar(it) }) {
    fun tryRace() {
        racingCars.forEach { racingCar -> racingCar.run() }
    }
}
