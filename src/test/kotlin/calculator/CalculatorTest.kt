package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @Test
    fun `문자열로 계산`() {
        val actual = Calculator.calc("2 + 3 * 4 / 2")
        assertThat(actual).isEqualTo(10.0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "   ", "  \t"])
    fun `입력이 blank 일때`(source: String) {
        assertThrows<IllegalArgumentException> { Calculator.calc(source) }
    }
}
