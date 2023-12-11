package Model

import kotlin.random.Random

data class Car(val id: String, var position: MutableList<Int> = mutableListOf(0)) {
    fun moveForward() {
        when (4 <= Random.nextInt(10)) {
            true -> position.add(position[position.size - 1] + 1)
            false -> position.add(position[position.size - 1])
        }
    }
}
