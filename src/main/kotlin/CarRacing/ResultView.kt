package CarRacing

object ResultView {
    const val PROMPT_START = "실행 결과"
    const val CAR_PROGRESS_SYMBOL = "-"
    fun showStart() {
        println()
        println(PROMPT_START)
    }

    fun showRacingCar(racingCar: RacingCar) {
        println(CAR_PROGRESS_SYMBOL.repeat(racingCar.progress))
    }

    fun showRaceSnapShot(race: Race) {
        race.racingCars.forEach { racingCar -> showRacingCar(racingCar) }
        println()
    }
}
