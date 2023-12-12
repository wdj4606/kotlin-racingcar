package step3

class Cars(quantity: Int) {
    val cars: List<Car> = List(quantity) { Car() }

    fun goForward() {
        cars.forEach(Car::moveForward)
    }
}
