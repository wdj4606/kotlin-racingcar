package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import step2.model.Calculator

class CalculatorTest {
    @Test
    fun `null 혹은 빈값`() {
        assertThrows<IllegalArgumentException> { Calculator.calculate("") }
    }

    @Test
    fun `잘못된 수식`() {
        assertThrows<IllegalArgumentException> { Calculator.calculate("1 +") }
    }

    @Test
    fun `지원하지 않는 연산기호`() {
        assertThrows<IllegalArgumentException> { Calculator.calculate("1 % 2") }
    }

    @Test
    fun `계산1`() {
        val result = Calculator.calculate("5 - 4 + 1 * 2 / 2")
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `계산2`() {
        val result = Calculator.calculate("2 + 2 * 2 / 2 - 2")
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `곱하기`() {
        val result = Calculator.calculate("13 * 2 / 2 - 4 + 1")
        assertThat(result).isEqualTo(10)
    }
}
