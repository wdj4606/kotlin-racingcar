package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import step2.Calculator.calculate

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `null 또는 공백 문자열에 대해 EmptyExpressionException 반환`(input: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { calculate(input) }
            .withMessage(ExceptionType.EMPTY_EXPRESSION)
    }

    @Test
    fun `잘못된 형식의 수식에 대해 InvalidExpressionException 반환`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { calculate("2 + + 3") }
            .withMessage(ExceptionType.INVALID_EXPRESSION)
    }

    @Test
    fun `잘못된 숫자에 대해 InvalidNumberException 반환`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { calculate("2 + a") }
            .withMessage(ExceptionType.INVALID_NUMBER)
    }

    @Test
    fun `잘못된 연산자에 대해 InvalidOperatorException 반환`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { calculate("2 ^ 3") }
            .withMessage(ExceptionType.INVALID_OPERATOR)
    }

    @Test
    fun `0으로 나눌 때 DivisionByZeroException 반환`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { calculate("10 / 0") }
            .withMessage(ExceptionType.DIVISION_BY_ZERO)
    }

    @Test
    fun `정상적인 계산 상황`() {
        assertThat(calculate("2 + 3 * 4 / 2")).isEqualTo(10.0)
        assertThat(calculate("3 + 5 / 2")).isEqualTo(4.0)
        assertThat(calculate("10 - 2 * 2")).isEqualTo(16.0)
        assertThat(calculate("10 * 10 * 10")).isEqualTo(1000.0)
    }
}
