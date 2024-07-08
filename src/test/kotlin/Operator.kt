import java.math.BigDecimal

enum class Operator(val symbol: String, val operation: (BigDecimal, BigDecimal) -> BigDecimal) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a.divide(b, 10, java.math.RoundingMode.HALF_UP) });

    companion object {
        fun fromSymbol(symbol: String): Operator? {
            return values().find { it.symbol == symbol }
        }

        val validPattern: String
            get() = "[0-9 ${values().joinToString("") { "\\${it.symbol}" }}.]*"

        val splitPattern: String
            get() = "(?<=[${values().joinToString("") { "\\${it.symbol}" }}])|(?=[${values().joinToString("") { "\\${it.symbol}" }}])"
    }
}
