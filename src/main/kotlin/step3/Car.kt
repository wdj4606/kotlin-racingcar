package step3

class Car {
    var distance: Int = 0

    fun moveForward() {
        if (isGoForward()) distance++
    }

    private fun isGoForward(): Boolean {
        return RandomUtil.getRandomNumber() >= 4
    }
}
