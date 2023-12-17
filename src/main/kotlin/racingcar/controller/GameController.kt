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
        inputView.run {
            race = Race.from(getCarNames())
            tryCount = getTryCount()
        }
    }

    private fun run() {
        resultView.run {
            printCarStateHeader()
            repeat(tryCount) {
                printCarState(race.race())
            }
            printWinner(race.getWinners())
        }
    }
}
