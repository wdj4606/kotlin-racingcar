package step3

object CarRacing {
    var carList = mutableListOf<String>()

    fun initListInfo(carCount: Int) {
        carList = MutableList(carCount) { i -> "" }
    }

    fun goRacing() {
        repeat(carList.size) {
            addHyphen(it, (0..9).random())
        }
    }

    fun addHyphen(index: Int, randomNum: Int) {
        if (randomNum < 4)
            return

        carList[index] += "-"
    }
}

fun main() {
    val inputItem = InputView.getInputItem()

    CarRacing.initListInfo(inputItem.carCount)

    repeat(CarRacing.carList.size) {
        CarRacing.goRacing()
        ResultView.showResult(CarRacing.carList)
    }
}
