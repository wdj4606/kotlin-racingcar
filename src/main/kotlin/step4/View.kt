package step4

import java.util.*

private const val CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
private const val TRY_COUNT = "시도할 횟수는 몇 회인가요?"
private const val WINNER = "%s가 최종 우승했습니다."

const val ERROR_TRY_COUNT = "시도 횟수는 숫자여야 합니다."

object InputView {
    private val scanner = Scanner(System.`in`)

    fun inputCarNames(): List<String> {
        println(CAR_NAME)
        return scanner.nextLine().split(",").map { it.trim() }
    }

    fun inputTryCount(): Int {
        println(TRY_COUNT)
        val input = scanner.nextLine().trim()
        require(input.matches(Regex("\\d+"))) { ERROR_TRY_COUNT }
        return input.toInt()
    }
}

object ResultView {
    fun printWinners(winners: String) {
        print(WINNER.format(winners))
    }
}