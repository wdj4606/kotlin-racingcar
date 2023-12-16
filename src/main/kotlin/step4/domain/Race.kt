package step4.domain

import step4.util.RandomUtil

data class Race(val participant: List<Car>, val attempt: Int) {
    fun run() {
        repeat(attempt) {
            participant.forEach { car -> car.moveForward(RandomUtil.getRandomNumber()) }
        }
    }
    fun getWinner(): List<Car> {
        val orderedList = participant.sortedByDescending { it.position.last() }
        return orderedList.filter { it.position.last() == orderedList.first().position.last() }
    }
}
