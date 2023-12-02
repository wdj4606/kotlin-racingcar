package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    val calculator: Calculator = Calculator()

    @Test
    fun `문자열로 계산`() {
        val actual = calculator.calc("2 + 3 * 4 / 2")
        assertThat(actual).isEqualTo(10.0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "   ", "  \t"])
    fun `입력이 blank 일때`(source: String) {
        assertThrows<IllegalArgumentException> { calculator.calc(source) }
    }
}
