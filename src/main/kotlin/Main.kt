import Model.Car
import Model.Race
import View.InputView
import View.ResultView

fun main() {
    val inputView = InputView()

    val participant = List<Car>(inputView.inputNumberOfCars(), { Car(it.toString()) })
    val race = Race(participant, inputView.inputNumberOfAttempts())
    race.run()

    val resultView = ResultView(race)
    resultView.printResult()
}
