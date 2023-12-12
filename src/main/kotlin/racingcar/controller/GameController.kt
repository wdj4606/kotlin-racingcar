package racingcar.controller

import racingcar.model.Race
import racingcar.view.InputView
import racingcar.view.ResultView

class GameController(
    private val inputView: InputView,
    private val resultView: ResultView,
) {
    private lateinit var race: Race
    private var tryCount: Int = 0

    fun gameStart() {
        initializeGame()
        run()
    }

    private fun initializeGame() {
        race = Race.from(inputView.getCarCount())
        tryCount = inputView.getTryCount()
    }

    private fun run() {
        resultView.printCarStateHeader()

        repeat(tryCount) {
            race.moveOneTick()
            resultView.printCarState(race.getCarInfo())
        }
    }
}
