package step3

object ResultView {

    fun printRoundResult(cars: List<Car>) {
        println("실행 결과")
        cars.forEach { car ->
            println("-".repeat(car.position))
        }
        println()
    }
}
