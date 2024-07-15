package CarRacing.View

import CarRacing.Domain.Race
import CarRacing.Domain.RacingCar

object ResultView {
    private const val PROMPT_START = "실행 결과"
    private const val CAR_PROGRESS_SYMBOL = "-"
    fun showStart() {
        println()
        println(PROMPT_START)
    }

    private fun showRacingCar(racingCar: RacingCar) {
        print(racingCar.carName)
        print(" : ")
        println(CAR_PROGRESS_SYMBOL.repeat(racingCar.progress))
    }

    fun showRaceSnapShot(race: Race) {
        race.racingCars.forEach { racingCar -> showRacingCar(racingCar) }
        println()
    }

    fun showResult(race: Race) {
        val winnerNames = race.getWinners()
        val racingCarsNamesString = winnerNames.joinToString(", ") { it }
        println(racingCarsNamesString)
    }
}
