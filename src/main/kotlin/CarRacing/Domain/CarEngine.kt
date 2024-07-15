package CarRacing.Domain

class CarEngine(var random: Int = 0) {
    fun isRunnable(): Boolean {
        return random >= THRESHOLD_VALUE
    }

    companion object {
        const val THRESHOLD_VALUE = 4
    }
}
