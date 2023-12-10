package View

class ResultView(val raceLog: MutableList<MutableList<Int>>) {
    fun printResult() {
        for (i in 1 until raceLog.size) {
            println("${i}번째 시도")
            for (j in 0 until raceLog[i].size) {
                print("${j + 1}번째 자동차 : ")
                printRacingSkidMark(raceLog[i][j])
                println()
            }
            println()
        }
    }

    private fun printRacingSkidMark(number: Int) {
        for (i in 1..number) {
            print("-")
        }
    }
}
