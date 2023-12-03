package step2.Calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {

    val calculator: Calculator = Calculator()

    @Test
    fun `문자열 계산`() {
        val result = calculator.calculate("2 + 3 * 4 / 2")
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `입력값이 null 이거나 빈 공백 문자1`() {
        assertThrows<IllegalArgumentException> { calculator.calculate("") }
    }

    @Test
    fun `입력값이 null 이거나 빈 공백 문자2`() {
        assertThrows<IllegalArgumentException> { calculator.calculate(" + ") }
    }

    @Test
    fun `사친연산 기호가 아닌 경우`() {
        assertThrows<IllegalArgumentException> { calculator.calculate("2 % 3 & 4 $ 2") }
    }
}
