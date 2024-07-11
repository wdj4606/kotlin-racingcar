import CarRacing.InputView
import CarRacing.Race
import CarRacing.ResultView

fun main() {
    val inputParameters = InputView.run()
    val race = Race(inputParameters.numberOfCar)

    ResultView.showStart()
    repeat(inputParameters.numberOfRace) {
        race.tryRace()
        ResultView.showRaceSnapShot(race)
    }
}
