package step2

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

enum class Operator(val symbol: String) : BinaryOperator<Int>, IntBinaryOperator {

    PLUS("+") {
        override fun apply(x: Int, y: Int): Int = x.plus(y)
    },
    MINUS("-") {
        override fun apply(x: Int, y: Int): Int = x.minus(y)
    },
    MULTIPLY("*") {
        override fun apply(x: Int, y: Int): Int = x.times(y)
    },
    DIVIDE("/") {
        override fun apply(x: Int, y: Int): Int = x.div(y)
    };

    override fun applyAsInt(left: Int, right: Int): Int = apply(left, right)

    companion object {
        fun from(symbol: String): Operator {
            return values().firstOrNull { it.symbol == symbol }
                ?: throw IllegalArgumentException("지원하지 않는 연산자입니다.")
        }
    }
}
