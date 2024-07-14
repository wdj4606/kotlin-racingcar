package step3

object ResultView {

    fun printRoundResult(cars: List<Car>) {
        cars.forEach { car ->
            println("-".repeat(car.position))
        }
        println()
    }
}
