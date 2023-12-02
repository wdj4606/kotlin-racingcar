package step3

object CarRacing {
    var carList = mutableListOf<String>()

    fun initListInfo(carCount: Int) {
        carList = MutableList(carCount) { i -> "" }
    }

    fun startGame(inputItem: InputItem) {
        for (i in 0 until inputItem.tryCount) {
            goRacing()
        }
    }

    fun goRacing() {
        for (i in 0 until carList.size) {
            addHyphen(i, (0..9).random())
        }

        ResultView.showResult(carList)
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
    CarRacing.startGame(inputItem)
}
