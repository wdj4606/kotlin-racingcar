package racingcar

import racingcar.controller.GameController
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val game = GameController(InputView, ResultView)

    game.gameStart()
}
