package View

import Model.Race

class ResultView(val race: Race) {
    fun printResult() {
        for (i in 1..race.attempt) {
            println("${i}번째 시도")
            for (j in 0 until race.participant.size) {
                print("${j + 1}번째 자동차 : ")
                printRacingSkidMark(race.participant[j].position[i])
                println()
            }
            println()
        }
    }

    private fun printRacingSkidMark(number: Int) {
        repeat(number) {
            print("-")
        }
    }
}
