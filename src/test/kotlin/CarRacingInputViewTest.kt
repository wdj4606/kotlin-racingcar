import CarRacing.InputView
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import java.io.ByteArrayInputStream

class CarRacingInputViewTest {
    @Test
    fun `자동차 대수랑 시도 횟수 입력 잘 되니?`() {
        assertDoesNotThrow {
            val input = "1\n2\n"
            val inputStream = ByteArrayInputStream(input.toByteArray())
            System.setIn(inputStream)

            val inputParameter = InputView.run()
            assertThat(inputParameter.numberOfCar).isEqualTo(1)
            assertThat(inputParameter.numberOfRace).isEqualTo(2)
        }
    }

    @Test
    fun `숫자 아닌거 예외처리 잘되니?`() {
        assertThatThrownBy {
            val input = "하이\n2\n"
            val inputStream = ByteArrayInputStream(input.toByteArray())
            System.setIn(inputStream)
            InputView.run()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(InputView.ERR_INPUT_NUMBER_OF_CAR)

        assertThatThrownBy {
            val input = "11\n싫어\n"
            val inputStream = ByteArrayInputStream(input.toByteArray())
            System.setIn(inputStream)
            InputView.run()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(InputView.ERR_INPUT_NUMBER_OF_RACE)
    }

    @Test
    fun `양수 이외에 예외처리 잘되니?`() {
        assertThatThrownBy {
            val input = "10\n0\n"
            val inputStream = ByteArrayInputStream(input.toByteArray())
            System.setIn(inputStream)
            InputView.run()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(InputView.ERR_INPUT_NUMBER_OF_RACE)

        assertThatThrownBy {
            val input = "-1\n10\n"
            val inputStream = ByteArrayInputStream(input.toByteArray())
            System.setIn(inputStream)
            InputView.run()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageMatching(
                InputView.ERR_INPUT_NUMBER_OF_CAR
            )

        assertDoesNotThrow {
            val input = "1\n02\n"
            val inputStream = ByteArrayInputStream(input.toByteArray())
            System.setIn(inputStream)
            InputView.run()
        }
    }
}
