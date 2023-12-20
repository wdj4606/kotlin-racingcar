package racingcar.model

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarsTest : BehaviorSpec({
    given("a list of cars") {
        val alwaysMoveStrategy = MovableStrategy { true }
        val car1 = Car("car1", alwaysMoveStrategy)
        val car2 = Car("car2", alwaysMoveStrategy)
        val cars = Cars.from(listOf(car1, car2))

        `when`("the cars are moved") {
            cars.move()

            then("all cars should have updated positions") {
                val positions = cars.getCars().map { it.position }
                positions shouldBe listOf(1, 1) // Assuming all cars move by one position
            }
        }
    }

    given("a list of cars with a filter condition") {
        val alwaysMoveStrategy = MovableStrategy { true }
        val car1 = Car("car1", alwaysMoveStrategy)
        val car2 = Car("car2", alwaysMoveStrategy)
        val cars = Cars.from(listOf(car1, car2))

        `when`("filtering cars based on a predicate") {
            val filteredCars = cars.filter { it.name == "car1" }

            then("only the matching cars should be present") {
                filteredCars.getCars().size shouldBe 1
                filteredCars.getCars().first().name shouldBe "car1"
            }
        }
    }

    given("a list of cars with varying positions") {
        val alwaysMoveStrategy = MovableStrategy { true }
        val neverMoveStrategy = MovableStrategy { false }
        val car1 = Car("car1", alwaysMoveStrategy)
        val car2 = Car("car2", alwaysMoveStrategy)
        val cars = Cars.from(listOf(car1, car2))
        cars.move()
        cars.move()

        `when`("getting the maximum position") {
            val maxPosition = cars.getMaxPosition()

            then("it should be the maximum position of all cars") {
                maxPosition shouldBe 2
            }
        }
    }
})
