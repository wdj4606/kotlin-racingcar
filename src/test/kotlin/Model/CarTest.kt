package Model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차 정보 입력`() {
        val car = Car("1")
        assertThat(car.id == "1").isTrue()
    }
}
