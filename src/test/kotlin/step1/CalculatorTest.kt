package step1

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest() {

    private val calculator: Calculator = Calculator()

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2"])
    fun `계산기 테스트`(input: String) {
        val actual = calculator.calculate(input)
        assertThat(actual).isEqualTo(10)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `예외 처리 테스트`(input: String) {

        assertThatIllegalArgumentException().isThrownBy { calculator.calculate(input) }
    }
}
