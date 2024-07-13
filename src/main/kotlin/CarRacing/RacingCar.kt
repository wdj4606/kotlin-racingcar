package CarRacing

const val NA_NAME = "NO_NAME"
const val INITIAL_PROGRESS = 0
const val THRESHOLD_VALUE = 4

class RacingCar(val carName: String = NA_NAME, var progress: Int = INITIAL_PROGRESS, val carEngine: CarEngine = CarEngine()) {
    fun run() {
        if (carEngine.isRunnable())
            progress += 1
    }
}
