package step5.domain

data class Car(val name: String, var movingCount: Int) {
    fun move(randomNum: Int) {
        if (randomNum < 4)
            return

        this.movingCount += 1
    }
}
