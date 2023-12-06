package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.haveMessage

class CalculatorTest : DescribeSpec({
    val calculator = Calculator

    describe("calculate") {
        context("계산식이 비어있으면 IllegalArgumentException") {
            it("계산식이 비어있으면 IllegalArgumentException") {
                // then
                nullOrEmptyCalculations.forAll {
                    val shouldThrow = shouldThrow<IllegalArgumentException> {
                        calculator.calculate(it)
                    }
                    shouldThrow.message shouldBe "계산식이 비어있습니다."
                }
            }
        }
        context("계산식이 잘못되었으면 IllegalArgumentException") {
            it("계산식이 잘못되었으면 IllegalArgumentException") {
                // then
                invalidCalculations.forAll {
                    shouldThrow<IllegalArgumentException> {
                        calculator.calculate(it)
                        haveMessage("지원하지 않는 연산자입니다.")
                    }
                }
            }
        }
        context("정상 계산") {
            it("정상 계산") {
                calculations.forAll {
                    // when
                    val result = calculator.calculate(it.first)
                    // then
                    result shouldBe it.second
                }
            }
        }
        context("숫자가 아닌 경우 IllegalArgumentException") {
            it("숫자가 아닌 경우 IllegalArgumentException") {
                // then
                notNumber.forAll {
                    shouldThrow<IllegalArgumentException> {
                        calculator.calculate(it)
                        haveMessage("숫자가 아닙니다.")
                    }
                }
            }
        }
    }
}

) {
    companion object {
        val calculations = listOf("1 + 2" to 3, "1 + 2 + 3 + 4" to 10, "2 + 3 * 4 / 2" to 10)
        val nullOrEmptyCalculations = listOf("", " ", "  ")
        val invalidCalculations = listOf("1 % 2", "1 & 2")
        val notNumber = listOf("1 + a", "1 + b", "1 + c")
    }
}
