package CarRacing.Domain

enum class RaceErrorMessage(val message: String) {
    NO_CARS("차량 없음");
}

class Race(val racingCars: List<RacingCar> = List(3) { RacingCar() }) {
    fun tryRace() {
        racingCars.forEach { racingCar -> racingCar.run() }
    }

    fun tryRandom() {
        racingCars.forEach { racingCar -> racingCar.random() }
    }

    fun tryAffterRandom() {
        tryRandom()
        tryRace()
    }

    fun getWinners(): List<String> {
        val maxLength = racingCars.maxOfOrNull { it.progress }
        require(maxLength != null) { RaceErrorMessage.NO_CARS }
        val filteredCars = racingCars.filter { it.progress == maxLength }
        return filteredCars.map { it.carName }
    }
}
