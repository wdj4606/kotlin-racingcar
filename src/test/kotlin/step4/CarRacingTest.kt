package step4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarRacingTest {
    @Test
    fun `데이터 초기화`() {
        CarRacing.initListInfo("a,b,c,d")

        assertThat(CarRacing.carList)
            .isEqualTo(mutableListOf(Car("a", 0), Car("b", 0), Car("c", 0), Car("d", 0)))
        assertThat(CarRacing.carList.size).isEqualTo(4)
    }

    @Test
    fun `카운트 추가`() {
        CarRacing.initListInfo("a,b,c")
        CarRacing.plusCount(0, 3)
        CarRacing.plusCount(1, 5)
        CarRacing.plusCount(2, 2)

        assertThat(CarRacing.carList[0].movingCount).isEqualTo(0)
        assertThat(CarRacing.carList[1].movingCount).isEqualTo(1)
        assertThat(CarRacing.carList[2].movingCount).isEqualTo(0)
    }

    @Test
    fun `결과 가져오기`() {
        CarRacing.initListInfo("a,b,c")
        CarRacing.plusCount(0, 3)
        CarRacing.plusCount(1, 5)
        CarRacing.plusCount(2, 2)

        assertThat(CarRacing.getFinalResult()).isEqualTo("b")
    }
}
