package step4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarRacingTest {
    @Test
    fun `데이터 초기화`() {
        val carName: List<Car> = listOf(Car("a", 0), Car("b", 0), Car("c", 0))
        val carRacing = CarRacing(carName)

        assertThat(carRacing.carList)
            .isEqualTo(mutableListOf(Car("a", 0), Car("b", 0), Car("c", 0)))
        assertThat(carRacing.carList.size).isEqualTo(3)
    }

    @Test
    fun `카운트 추가`() {
        val carName: List<Car> = listOf(Car("a", 0), Car("b", 0), Car("c", 0))
        val carRacing = CarRacing(carName)

        carRacing.carList[0].move(3)
        carRacing.carList[1].move(5)
        carRacing.carList[2].move(2)

        assertThat(carRacing.carList[0].movingCount).isEqualTo(0)
        assertThat(carRacing.carList[1].movingCount).isEqualTo(1)
        assertThat(carRacing.carList[2].movingCount).isEqualTo(0)
    }

    @Test
    fun `결과 가져오기`() {
        val carName: List<Car> = listOf(Car("a", 0), Car("b", 0), Car("c", 0))
        val carRacing = CarRacing(carName)

        carRacing.carList[0].move(3)
        carRacing.carList[1].move(5)
        carRacing.carList[2].move(2)

        assertThat(carRacing.getFinalResult()).isEqualTo("b")
    }
}
