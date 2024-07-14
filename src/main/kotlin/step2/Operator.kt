package step2

import java.math.BigDecimal

enum class Operator(val symbol: String) {
    ADD("+") { override fun apply(a: BigDecimal, b: BigDecimal): BigDecimal = a + b },
    SUBTRACT("-") { override fun apply(a: BigDecimal, b: BigDecimal): BigDecimal = a - b },
    MULTIPLY("*") { override fun apply(a: BigDecimal, b: BigDecimal): BigDecimal = a * b },
    DIVIDE("/") {
        override fun apply(a: BigDecimal, b: BigDecimal): BigDecimal {
            require(b != BigDecimal.ZERO) { ExceptionType.DIVISION_BY_ZERO }
            return a / b
        }
    };

    abstract fun apply(a: BigDecimal, b: BigDecimal): BigDecimal

    companion object {
        private val map = values().associateBy(Operator::symbol)

        fun from(symbol: String): Operator {
            return map[symbol] ?: throw IllegalArgumentException(ExceptionType.INVALID_OPERATOR)
        }
    }
}
