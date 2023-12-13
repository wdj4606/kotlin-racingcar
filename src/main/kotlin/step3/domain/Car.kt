package step3.domain

class Car {
    var progress: Int = 0

    fun move() {
        progress += onGoingCheck()
    }

    private fun onGoingCheck(): Int {
        val random = (Math.random() * 10).toInt()
        if (random >= 4) {
            return 1
        }
        return 0
    }

    fun printProgress() {
        for (i in 0 until progress) {
            print("-")
        }
        println()
    }
}
