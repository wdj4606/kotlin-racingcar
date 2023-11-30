package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {

    @Test
    fun `덧셈`() {
        val addItem = add(1.0, 2.0)
        assertThat(addItem).isEqualTo(3.0)
    }

    @Test
    fun `뺄셈`() {
        val subtractItem = subtract(1.0, 2.0)
        assertThat(subtractItem).isEqualTo(-1.0)
    }

    @Test
    fun `곱셈`() {
        val multiplyItem = multiply(1.0, 2.0)
        assertThat(multiplyItem).isEqualTo(2.0)
    }

    @Test
    fun `나눗셈`() {
        val divideItem = divide(1.0, 2.0)
        assertThat(divideItem).isEqualTo(0.5)
    }

    @Test
    fun `입력값 null or 빈 공백`() {
        val nullItem = null
        val emptyItem = ""

        assertThrows<IllegalArgumentException> {
            calculate(nullItem)
        }

        assertThrows<IllegalArgumentException> {
            calculate(emptyItem)
        }
    }

    @Test
    fun `사칙연산 기호 아님`() {
        val noOperator = "1 2 3"
        val noNumber = "+ 1"

        assertThrows<IllegalArgumentException> {
            calculate(noOperator)
        }

        assertThrows<NumberFormatException> {
            calculate(noNumber)
        }
    }

    @Test
    fun `계산 성공 테스트`() {
        val calcData = calculate("2 + 3 * 4 / 2")
        assertThat(calcData).isEqualTo("10.0")
    }
}
