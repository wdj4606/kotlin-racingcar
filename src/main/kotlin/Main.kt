import Controller.RacingController
import Model.Car
import Model.Race
import View.InputView
import View.ResultView

fun main() {
    val inputView = InputView()
    inputView.inputNumberOfCars()
    inputView.inputNumberOfAttempts()

    val participant = List<Car>(inputView.getNumberOfCars(), { Car(it.toString()) })
    val race = Race(participant, inputView.getNumberOfAttempts())

    val racingController = RacingController(race)
    racingController.run()

    val resultView = ResultView(racingController.raceLog)
    resultView.printResult()
}
