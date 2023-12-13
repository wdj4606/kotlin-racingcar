package step3

import step3.ui.InputView
import step3.ui.OutputView

class Main
fun main() {

    InputView.inputCarNumbers()
    InputView.inputTryNumbers()
    OutputView.cars = MutableList(InputView.carNumbers) { Car() }

    repeat(InputView.tryNumbers) {
        OutputView.printResult()
    }
}
