package Model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차 정보 입력`() {
        val car = Car("1")
        assertThat(car.id == "1").isTrue()
    }

    @Test
    fun `자동차 초기 위치 확인`() {
        val car = Car("1")
        assertThat(car.position[0] == 0).isTrue()
    }

    @Test
    fun `자동차 전진 시도 확인`() {
        val car = Car("1")
        assertThat(car.position.size == 1).isTrue()
        car.moveForward()
        assertThat(car.position.size == 2).isTrue()
        car.moveForward()
        assertThat(car.position.size == 3).isTrue()
    }
}
