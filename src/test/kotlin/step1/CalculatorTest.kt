package step1

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest() {

    private val calculator: Calculator = Calculator

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2"])
    fun `계산기 테스트1`(input: String) {
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(10)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 - 5 / 3"])
    fun `계산기 테스트2`(input: String) {
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(5)
    }

    @ParameterizedTest
    @ValueSource(strings = ["10 - 9"])
    fun `계산기 테스트3`(input: String) {
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(strings = ["15 + 9 - 16 / 2"])
    fun `계산기 테스트4`(input: String) {
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(4)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `예외 처리 테스트1`(input: String) {
        assertThatIllegalArgumentException().isThrownBy { calculator.calculate(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["* 1 + 2", "1 * *", "1 1 *"])
    fun `예외 처리 테스트2`(input: String) {
        assertThatIllegalArgumentException().isThrownBy { calculator.calculate(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 / 0"])
    fun `예외 처리 테스트3`(input: String) {
        assertThrows<ArithmeticException> { calculator.calculate(input) }
    }
}
