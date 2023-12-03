package step2

import io.kotest.core.spec.style.DescribeSpec
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

internal class CalculatorTest : DescribeSpec({
    val calculator = Calculator

    describe("calculate") {
        context("계산식이 비어있으면 IllegalArgumentException") {
            it("계산식이 비어있으면 IllegalArgumentException") {
                // then
                nullOrEmptyCalculations.forEach {
                    assertThatThrownBy { calculator.calculate(it) }
                        .isInstanceOf(IllegalArgumentException::class.java)
                        .hasMessage("계산식이 비어있습니다.")
                }
            }
        }
        context("계산식이 잘못되었으면 IllegalArgumentException") {
            it("계산식이 잘못되었으면 IllegalArgumentException") {
                // then
                invalidCalculations.forEach {
                    assertThatThrownBy { calculator.calculate(it) }
                        .isInstanceOf(IllegalArgumentException::class.java)
                        .hasMessage("지원하지 않는 연산자입니다.")
                }
            }
        }
        context("정상 계산") {
            it("정상 계산") {
                calculations.forEach {
                    // when
                    val result = calculator.calculate(it.first)
                    // then
                    assertThat(result).isEqualTo(it.second)
                }
            }
        }
    }
}

) {

    companion object {
        var calculations = listOf("1 + 2" to 3, "1 + 2 + 3 + 4" to 10, "2 + 3 * 4 / 2" to 10)
        var nullOrEmptyCalculations = listOf("", " ", "  ")
        var invalidCalculations = listOf("1 % 2", "1 & 2")
    }
}
