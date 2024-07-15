package CarRacing

const val NO_NAME = "NAME"
const val INITIAL_PROGRESS = 0
const val THRESHOLD_VALUE = 4

class RacingCar(val carName: String = NO_NAME, var progress: Int = INITIAL_PROGRESS, val carEngine: CarEngine = CarEngine()) {
    init {
        require(carName.length <= 5) { ERR_NAME_LENGTH }
    }

    fun run() {
        if (carEngine.isRunnable())
            progress += 1
    }

    companion object {
        private const val ERR_NAME_LENGTH = "자동차 이름은 5자를 초과할 수 없습니다"
    }
}
