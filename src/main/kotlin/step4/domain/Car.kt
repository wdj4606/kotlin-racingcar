package step4.domain

data class Car(val name: String, var position: MutableList<Int> = mutableListOf(0)) {
    fun moveForward(randomNumber: Int) {
        when (4 <= randomNumber) {
            true -> position.add(position[position.size - 1] + 1)
            false -> position.add(position[position.size - 1])
        }
    }
}
