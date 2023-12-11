package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : DescribeSpec({

    describe("Calculator") {

        context("유효한 사칙연산 값이 들어오면") {

            it("유효한 결과 값을 반환한다") {
                val inputList = arrayOf("3 + 5 * 2 - 6 / 2")
                Calculator.calculate(inputList) shouldBe 5
            }
        }

        context("비어있는 값을 넣으면") {

            it("IllegalArgumentException 예외를 발생시킨다") {
                val inputList = emptyArray<String>()
                shouldThrow<IllegalArgumentException> { Calculator.calculate(inputList) }
            }
        }

        context("첫 입력값이 숫자가 아닐 경우") {

            it("IllegalArgumentException 예외를 발생시킨다") {
                val inputList = arrayOf("abc + 5 * 2 - 6 / 2")
                shouldThrow<IllegalArgumentException> { Calculator.calculate(inputList) }
            }
        }

        context("유효하지 않은 구간에 연산자가 있으면") {

            it("IllegalArgumentException 예외를 발생시킨다") {
                val inputList = arrayOf("3 + 5 * 2 - 6 /")
                shouldThrow<IllegalArgumentException> { Calculator.calculate(inputList) }
            }
        }

        context("연산자가 유효하지 않은 값이면") {

            it("IllegalArgumentException 예외를 발생시킨다") {
                val inputList = arrayOf("3 + 5 * 2 - x / 2")
                shouldThrow<IllegalArgumentException> { Calculator.calculate(inputList) }
            }
        }
    }

    describe("Operator") {

        context("더하기 연산이 들어오면") {

            it("두 수를 더한 값을 반환한다") {
                Operator.PLUS.calculate(3, 5) shouldBe 8
            }
        }

        context("빼기 연산이 들어오면") {

            it("두 수를 뺀 값을 반환한다") {
                Operator.MINUS.calculate(5, 3) shouldBe 2
            }
        }

        context("곱하기 연산이 들어오면") {

            it("두 수를 곱한 값을 반환한다") {
                Operator.MULTIPLY.calculate(3, 5) shouldBe 15
            }
        }

        context("나누기 연산이 들어오면") {

            it("두 수를 나눈 값을 반환한다") {
                Operator.DIVIDE.calculate(6, 2) shouldBe 3
            }
        }

        context("사칙연산 이외의 연산자가 들어오면") {

            it("IllegalArgumentException 예외를 발생시킨다") {
                shouldThrow<IllegalArgumentException> { Operator.of("#") }
            }
        }
    }
})
