package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : DescribeSpec({

    describe("Calculator") {
        it("should throw IllegalArgumentException for missing input") {
            val exception = shouldThrow<IllegalArgumentException> {
                main(emptyArray())
            }
            exception.message shouldBe "입력값은 필수입니다."
        }

        it("should throw IllegalArgumentException for invalid expression") {
            val args = arrayOf("5 * 2 +")
            val exception = shouldThrow<IllegalArgumentException> {
                main(args)
            }
            exception.message shouldBe "올바른 식이 아닙니다."
        }

        it("should run without errors") {
            val args = arrayOf("5 * 2 + 10 / 2")
            main(args)
        }

        it("should add two numbers") {
            val result = Calculator.calculate(5.0, 10.0, "+")
            result shouldBe 15.0
        }

        it("should subtract two numbers") {
            val result = Calculator.calculate(3.0, 10.0, "-")
            result shouldBe 7.0
        }

        it("should multiply two numbers") {
            val result = Calculator.calculate(4.0, 5.0, "*")
            result shouldBe 20.0
        }

        it("should divide two numbers") {
            val result = Calculator.calculate(8.0, 16.0, "/")
            result shouldBe 2.0
        }

        it("should throw IllegalArgumentException for invalid operator") {
            val exception = shouldThrow<IllegalArgumentException> {
                Calculator.calculate(2.0, 5.0, "%")
            }
            exception.message shouldBe "연산자가 올바른 형식이 아닙니다.(+,-,*,/ 만 가능)"
        }
    }
})
