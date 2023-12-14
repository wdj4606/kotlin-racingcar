package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.domain.Car
import step3.domain.ON_GOING_CHECK_VALUE
import kotlin.random.Random

class CarTest {
    @Test
    fun `ON_GOING_CHECK_VALUE의 값으로 이동 테스트`() {
        val car = Car()
        car.move(ON_GOING_CHECK_VALUE)
        assertThat(car.getProgress()).isEqualTo(1)
    }

    @Test
    fun `4보다 작은 값으로 이동 테스트`() {
        val car = Car()
        car.move(3)
        assertThat(car.getProgress()).isEqualTo(0)
    }

    @Test
    fun `값이 0인 이동 테스트`() {
        val car = Car()
        car.move(0)
        assertThat(car.getProgress()).isEqualTo(0)
    }

    @Test
    fun `0보다 작은 값으로 이동 테스트`() {
        val car = Car()
        car.move(-1)
        assertThat(car.getProgress()).isEqualTo(0)
    }

    @Test
    fun `ON_GOING_CHECK_VALUE 보다 큰 값으로 이동 테스트`() {
        val car = Car()
        car.move(5)
        assertThat(car.getProgress()).isEqualTo(1)
    }

    @Test
    fun `다른 값으로 여러 번 이동 테스트`() {
        val car = Car()
        car.move(2)
        car.move(3)
        car.move(1)
        assertThat(car.getProgress()).isEqualTo(0)
    }

    @Test
    fun `임의 값 카운트 테스트`() {
        val car = Car()
        val randomValues = List(100) { Random.nextInt(10) } // List of 100 random integers between 0 and 9
        randomValues.forEach { value ->
            car.move(value)
        }

        val expectedProgress = randomValues.count { it >= ON_GOING_CHECK_VALUE }
        assertThat(car.getProgress()).isEqualTo(expectedProgress)
    }
}
