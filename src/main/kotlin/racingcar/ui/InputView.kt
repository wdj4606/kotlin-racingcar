package racingcar.ui

class InputView {
    var carNames: List<String> = emptyList()
    var tryNum: Int = 0
    fun input() {
        print("names of car : ")
        carNames = readln().split(",")
        carNames.forEach {
            require(it.length <= 5) { "name length is more than 5" }
        }
        print("number of try : ")
        tryNum = readln().toInt()
    }
}
