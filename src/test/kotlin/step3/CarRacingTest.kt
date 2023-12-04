package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarRacingTest {

    @Test
    fun `데이터 초기화`() {
        CarRacing.initListInfo(3)

        assertThat(CarRacing.carList.size).isEqualTo(3)
    }

    @Test
    fun `하이픈 추가`() {
        CarRacing.initListInfo(3)
        CarRacing.addHyphen(0, 3)
        CarRacing.addHyphen(1, 5)

        assertThat(CarRacing.carList[0]).isEqualTo("")
        assertThat(CarRacing.carList[1]).isEqualTo("-")
    }

    @Test
    fun `레이싱,,`() {
        // 이걸 어케 테스트하지ㅋㅋㅋㅋ
    }
}
