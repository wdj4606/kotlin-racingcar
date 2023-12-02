package racingcar.ui

class InputView {
    var carNum: Int = 0
    var tryNum: Int = 0
    fun input() {
        print("number of car : ")
        carNum = readln().toInt()
        print("number of try : ")
        tryNum = readln().toInt()
    }
}
