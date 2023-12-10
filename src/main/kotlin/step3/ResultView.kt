package step3

object ResultView {

    fun printResult(cars: Cars) {
        for (car in cars.cars) {
            printOneCarState(car)
        }
        println()
    }

    private fun printOneCarState(car: Car) {
        for (i in 1..car.distance) {
            print("-")
        }
        println()
    }
}
