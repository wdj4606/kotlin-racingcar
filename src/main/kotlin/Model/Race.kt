package Model

data class Race(val participant: List<Car>, val attempt: Int) {
    fun run() {
        for (i in 1..attempt) {
            participant.forEach { car ->
                car.moveForward()
            }
        }
    }
}
