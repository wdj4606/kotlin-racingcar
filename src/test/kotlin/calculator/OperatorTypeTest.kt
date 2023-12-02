package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OperatorTypeTest {
    @Test
    fun `문자로 부터 Type 얻기`() {
        val plus = OperatorType.fromSymbol("+")
        assertThat(plus).isEqualTo(OperatorType.PLUS)
        val minus = OperatorType.fromSymbol("-")
        assertThat(minus).isEqualTo(OperatorType.MINUS)
        val multiply = OperatorType.fromSymbol("*")
        assertThat(multiply).isEqualTo(OperatorType.MULTIPLY)
        val divide = OperatorType.fromSymbol("/")
        assertThat(divide).isEqualTo(OperatorType.DIVIDE)
    }

    @Test
    fun `enum 별 계산하기`() {
        assertThat(OperatorType.PLUS.calc(2.0, 5.0)).isEqualTo(7.0)
        assertThat(OperatorType.MINUS.calc(8.0, 2.0)).isEqualTo(6.0)
        assertThat(OperatorType.MULTIPLY.calc(4.0, 2.0)).isEqualTo(8.0)
        assertThat(OperatorType.DIVIDE.calc(25.0, 5.0)).isEqualTo(5.0)
    }
}
