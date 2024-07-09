package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import step2.Calculator.calculateExpression

class CalculatorTest {
    @Test
    fun `기본 사칙연산`() {

        calculateExpression("1 + 1").let {
            assertThat(it).isEqualTo(2.0)
        }

        calculateExpression("1 - 1").let {
            assertThat(it).isEqualTo(0.0)
        }

        calculateExpression("3 * 3").let {
            assertThat(it).isEqualTo(9.0)
        }

        calculateExpression("4 / 2").let {
            assertThat(it).isEqualTo(2.0)
        }

        calculateExpression("4 / 2 * 10 + 10 * 10").let {
            assertThat(it).isEqualTo(300.0)
        }
    }

    @Test
    fun `에러 케이스 - null 입력`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculateExpression(null)
        }
        val actualMessage = exception.message
        println(actualMessage)
    }

    @Test
    fun `에러 케이스 - 공백 입력`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculateExpression("   ")
        }
        val actualMessage = exception.message
        println(actualMessage)
    }

    @Test
    fun `에러 케이스 - 부적절한 문자 포함`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculateExpression("2 + 3 @ 4")
        }
        val actualMessage = exception.message
        println(actualMessage)
    }

    @Test
    fun `에러 케이스 - 정상적인 소수가 아닌 경우`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculateExpression("2.2.2 + 3")
        }
        val actualMessage = exception.message
        println(actualMessage)
    }

    @Test
    fun `에러 케이스 - 사칙 연산 기호가 연속으로 나오는 경우`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculateExpression("2 ++ 3")
        }
        val actualMessage = exception.message
        println(actualMessage)
    }

    @Test
    fun `에러 케이스 - 0으로 나누는 경우`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculateExpression("2 / 0")
        }
        val actualMessage = exception.message
        println(actualMessage)
    }

    @Test
    fun `에러 케이스 - 잘못된 표현식`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculateExpression("2 +")
        }
        val actualMessage = exception.message
        println(actualMessage)
    }
}
