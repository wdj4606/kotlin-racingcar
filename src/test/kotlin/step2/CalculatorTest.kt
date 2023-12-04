package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {

    @Test
    fun `덧셈`() {
        val addItem = Calculator.calcData(1, 2, "+")
        assertThat(addItem).isEqualTo(3)
    }

    @Test
    fun `뺄셈`() {
        val subtractItem = Calculator.calcData(1, 2, "-")
        assertThat(subtractItem).isEqualTo(-1)
    }

    @Test
    fun `곱셈`() {
        val multiplyItem = Calculator.calcData(1, 2, "*")
        assertThat(multiplyItem).isEqualTo(2)
    }

    @Test
    fun `나눗셈`() {
        val divideItem = Calculator.calcData(1, 2, "/")
        assertThat(divideItem).isEqualTo(0)
    }

    @Test
    fun `입력값 null or 빈 공백`() {
        val nullItem = null
        val emptyItem = ""

        assertThrows<IllegalArgumentException> {
            Calculator.calculate(nullItem)
        }

        assertThrows<IllegalArgumentException> {
            Calculator.calculate(emptyItem)
        }
    }

    @Test
    fun `사칙연산 기호 아님`() {
        val noOperator = "1 2 3"
        val noNumber = "+ 1"

        assertThrows<IllegalArgumentException> {
            Calculator.calculate(noOperator)
        }

        assertThrows<NumberFormatException> {
            Calculator.calculate(noNumber)
        }
    }

    @Test
    fun `계산 성공 테스트`() {
        val calcData = Calculator.calculate("2 + 3 * 4 / 2")
        assertThat(calcData).isEqualTo("10")
    }
}
