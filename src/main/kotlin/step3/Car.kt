package step3

import kotlin.random.Random

class Car() {
    var position: Int = 0
        private set

    fun move() {
        if (Random.nextInt(10) >= 4) {
            position++
        }
    }

    fun printState() {
        repeat(position) {
            print("-")
        }
        println()
    }
}

class RacingGame(val cars: List<Car>) {
    fun playRound() {
        cars.forEach { it.move() }
    }

    fun printState() {
        cars.forEach { it.printState() }
    }
}

class Input {
    companion object {
        fun readCarCount(): Int {
            println("자동차 대수는 몇 대인가요?")
            return readLine()?.toIntOrNull() ?: 0
        }

        fun readTryCount(): Int {
            println("시도할 횟수는 몇 회인가요?")
            return readLine()?.toIntOrNull() ?: 0
        }
    }
}

class Result {
    companion object {
        fun printResultHeader() {
            println("\n실행 결과")
        }
    }
}

fun main() {
    val carCount = Input.readCarCount()

    val cars = List(carCount) { Car() }

    val tryCount = Input.readTryCount()

    val game = RacingGame(cars)

    repeat(tryCount) {
        game.playRound()
        Result.printResultHeader()
        game.printState()
    }
}