package step4

object CarRacing {
    var carList = mutableListOf<Car>()

    fun initListInfo(carName: String) {
        val carNames = carName.split(',')

        carList = MutableList(carNames.size) { i -> Car(carNames[i], 0) }
    }

    fun goRacing() {
        repeat(carList.size) {
            plusCount(it, (0..9).random())
        }
    }

    fun plusCount(index: Int, randomNum: Int) {
        if (randomNum < 4)
            return

        carList[index].movingCount += 1
    }

    fun getFinalResult(): String {
        var maxCount = 0
        var firstCars = mutableListOf<String>()
        repeat(carList.size) {
            if (maxCount < carList[it].movingCount) maxCount = carList[it].movingCount
        }

        repeat(carList.size) {
            if (maxCount == carList[it].movingCount) firstCars.add(carList[it].name)
        }

        return firstCars.joinToString(",")
    }
}

fun main() {
    val inputItem = InputView.getInputItem()

    CarRacing.initListInfo(inputItem.carName)

    repeat(inputItem.tryCount) {
        CarRacing.goRacing()
        ResultView.showNowResult(CarRacing.carList)
    }

    val firstCars = CarRacing.getFinalResult()

    ResultView.showResult(firstCars)
}
