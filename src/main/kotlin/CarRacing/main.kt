import CarRacing.Domain.Race
import CarRacing.Domain.RacingCar
import CarRacing.View.InputView
import CarRacing.View.ResultView

fun main() {
    val inputParameters = InputView.run()
    val racingCars: List<RacingCar> = inputParameters.carNames.map { RacingCar(it) }
    val race = Race(racingCars)

    ResultView.showStart()
    repeat(inputParameters.numberOfRace) {
        race.tryAffterRandom()
        ResultView.showRaceSnapShot(race)
    }
    ResultView.showResult(race)
}
