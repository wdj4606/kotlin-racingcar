package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BaseCalculationTest {
    @Test
    fun `더하기`() {
        assertThat(Calculator("1 + 2").result()).isEqualTo(3)
        assertThat(Calculator("2 + 1").result()).isEqualTo(3)
    }

    @Test
    fun `빼기`() {
        assertThat(Calculator("1 - 2").result()).isEqualTo(-1)
        assertThat(Calculator("2 - 1").result()).isEqualTo(1)
    }

    @Test
    fun `곱하기`() {
        assertThat(Calculator("2 * 3").result()).isEqualTo(6)
        assertThat(Calculator("3 * 2").result()).isEqualTo(6)
        assertThat(Calculator("3 * 0").result()).isEqualTo(0)
        assertThat(Calculator("0 * 3").result()).isEqualTo(0)
        assertThat(Calculator("-1 * 3").result()).isEqualTo(-3)
        assertThat(Calculator("3 * -1").result()).isEqualTo(-3)
    }

    @Test
    fun `나누기`() {
        assertThat(Calculator("6 / 3").result()).isEqualTo(2)
        assertThat(Calculator("4 / 2").result()).isEqualTo(2)
        assertThat(Calculator("0 / 3").result()).isEqualTo(0)
        assertThat(Calculator("-6 / 3").result()).isEqualTo(-2)
        assertThat(Calculator("3 / -1").result()).isEqualTo(-3)
    }
}

class ExceptionTest {
    @ParameterizedTest
    @ValueSource(strings = ["1 / 0"])
    fun `0으로 나누기 예외`(input: String?) {
        assertThatThrownBy { Calculator(input!!).result() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("0으로 나눌 수 없습니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + a", "b + 1", "a + b", "1 + 2 + c", "1 + 0 + -"])
    fun `숫자가 아닌 경우 예외`(input: String?) {
        assertThatThrownBy { Calculator(input!!).result() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("숫자가 아닙니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 1 1", "1 ^ 2", "1 + 2 ) 3"])
    fun `지원하는 연산자가 아닌 경우 예외`(input: String?) {
        assertThatThrownBy { Calculator(input!!).result() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("지원하지 않는 연산자입니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "1", "1 2", "1 +", "1 + 2 +"])
    fun `연산자가 부족한 경우 예외`(input: String?) {
        assertThatThrownBy { Calculator(input!!).result() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력 값이 올바르지 않습니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = [""])
    fun `입력 값이 null인 경우 예외`(input: String?) {
        assertThatThrownBy { Calculator(input!!).result() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력 값이 올바르지 않습니다.")
    }
}
