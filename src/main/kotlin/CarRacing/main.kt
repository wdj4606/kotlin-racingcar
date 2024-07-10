import CarRacing.InputView
import CarRacing.Race

fun main() {
    val inputParameters = InputView.run()
    val race = Race(inputParameters)

    repeat(inputParameters.numberOfRace) { race.tryRace() }
}
