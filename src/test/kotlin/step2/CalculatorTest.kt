package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class CalculatorTest : DescribeSpec({

    describe("calculator") {
        context("입력으로 null이 주어지면") {
            it("IllegalArgumentException을 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    Calculator.calculate(null)
                }
            }
        }

        context("입력으로 빈 문자열이 주어지면") {
            it("IllegalArgumentException을 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    Calculator.calculate("")
                }
            }
        }

        context("입력으로 첫번째 인자로 숫자가 아닌 문자가 주어지면") {
            it("IllegalArgumentException을 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    Calculator.calculate("+ 2 + 3 + 4")
                }
            }
        }

        context("입력으로 마지막 인자로 숫자가 아닌 문자가 주어지면") {
            it("IllegalArgumentException을 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    Calculator.calculate("2 + 3 + 4 +")
                }
            }
        }

        context("정상 동작 확인") {
            it("연산 결과를 반환 한다.") {
                Calculator.calculate("2 + 3 * 4 / 2") shouldBe 10.0
            }
        }
    }
})
