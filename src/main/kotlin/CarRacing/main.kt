import CarRacing.InputView
import CarRacing.Race
import CarRacing.RacingCar
import CarRacing.ResultView

fun main() {
    val inputParameters = InputView.run()
    val racingCars: List<RacingCar> = inputParameters.carNames.map { RacingCar(it) }
    val race = Race(racingCars)

    ResultView.showStart()
    repeat(inputParameters.numberOfRace) {
        race.tryRace()
        ResultView.showRaceSnapShot(race)
    }
    ResultView.showResult(race)
}
