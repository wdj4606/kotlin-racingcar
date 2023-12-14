package step4.view

import step4.domain.Race

class ResultView(val race: Race) {
    fun printResult() {
        println("실행 결과")
        for (i in 1..race.attempt) {
            println("${i}번째 시도")
            printResultPerAttempt(i)
            println()
        }
        println()
        printWinner()
    }

    private fun printResultPerAttempt(i: Int) {
        for (j in race.participant.indices) {
            print("${race.participant[j].name} : ")
            printRacingSkidMark(race.participant[j].position[i])
            println()
        }
    }

    private fun printRacingSkidMark(number: Int) {
        repeat(number) {
            print("-")
        }
    }
    private fun printWinner() {
        println("${race.getWinner().joinToString { it.name }}가 최종 우승했습니다.")
    }
}
