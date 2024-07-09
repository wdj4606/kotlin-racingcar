import java.math.BigDecimal

enum class Operator(val symbol: String, val operation: (BigDecimal, BigDecimal) -> BigDecimal) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a.divide(b, 10, java.math.RoundingMode.HALF_UP) });

    companion object {
        const val ERR_OPERATOR_STRING = "잘못된 연산자가 발견됨"
        fun fromSymbol(symbol: String): Operator? {
            return values().find { it.symbol == symbol } ?: throw IllegalArgumentException(ERR_OPERATOR_STRING)
        }

        val splitPattern: String
            get() = "(?<=[${values().joinToString("") { "\\${it.symbol}" }}])|(?=[${values().joinToString("") { "\\${it.symbol}" }}])"
    }
}
