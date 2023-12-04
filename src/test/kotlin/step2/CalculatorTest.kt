package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class CalculatorTest {
    private fun assertExpressionEquals(expression: String, expected: Double) {
        val result = Calculator.calc(expression)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `test valid expression`() {
        assertAll(
            { assertExpressionEquals("3 + 4", 7.0) },
            { assertExpressionEquals("10 - 2 + 3", 11.0) },
            { assertExpressionEquals("5 * 3 / 2", 7.5) },
            { assertExpressionEquals("3 + 4 * 5 - 2 / 2", 16.5) },
            { assertExpressionEquals("8 / 2 * 4", 16.0) },
            { assertExpressionEquals("6 - 2 * 3", 12.0) },
            { assertExpressionEquals("2 + 3 * 4 / 2", 10.0) },
            { assertExpressionEquals("5 * 2 + 8 / 4", 4.5) },
        )
    }

    @Test
    fun `test expression with invalid operand`() {
        assertThrows<IllegalArgumentException> {
            Calculator.calc("3 + abc + 5")
        }
    }

    @Test
    fun `test expression with invalid operator`() {
        assertThrows<IllegalArgumentException> {
            Calculator.calc("3 & 4 + 5")
        }
    }

    @Test
    fun `test expression with consecutive operators`() {
        assertThrows<IllegalArgumentException> {
            Calculator.calc("3 + * 4 + 5")
        }
    }

    @Test
    fun `test expression with consecutive operands`() {
        assertThrows<IllegalArgumentException> {
            Calculator.calc("3 ++ 4 + 5")
        }
    }

    @Test
    fun `test expression with empty string`() {
        assertThrows<IllegalArgumentException> {
            Calculator.calc("")
        }
    }

    @Test
    fun `test expression with single operand`() {
        val result = Calculator.calc("7")
        assertThat(result).isEqualTo(7.0)
    }
}
