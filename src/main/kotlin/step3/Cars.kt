package step3

class Cars(quantity: Int) {
    val cars: MutableList<Car> = mutableListOf()

    init {
        for (i in 1..quantity) {
            cars.add(Car())
        }
    }

    fun goForward() {
        for (car in cars) {
            if (RandomUtil.isGoForward()) {
                car.moveForward()
            }
        }
    }
}
