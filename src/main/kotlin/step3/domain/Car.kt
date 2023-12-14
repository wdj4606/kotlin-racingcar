package step3.domain

const val DEFAULT_PROGRESS = 0
const val ON_GOING_CHECK_VALUE = 4
class Car(
    private var progress: Int = DEFAULT_PROGRESS
) {
    fun move(value: Int) {
        progress += onGoingCheck(value)
    }

    private fun onGoingCheck(value: Int): Int {
        if (value >= ON_GOING_CHECK_VALUE) {
            return 1
        }
        return 0
    }

    fun getProgress(): Int {
        return progress
    }
}
