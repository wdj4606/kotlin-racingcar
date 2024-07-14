package step3

fun main() {
    val carCount = InputView.getCarCount()
    val roundCount = InputView.getRoundCount()

    val cars = List(carCount) { Car() }
    val game = RaceGame(cars, roundCount)

    val raceResults = game.runRace()

    println("실행 결과")
    raceResults.forEach { ResultView.printRoundResult(it) }
}
