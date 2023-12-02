package calculator

enum class OperatorType(
    private val symbol: String,
    private val operator: (Double, Double) -> Double
) {

    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b });

    fun calc(value1: Double, value2: Double): Double {
        return this.operator(value1, value2)
    }

    companion object {
        fun fromSymbol(symbol: String): OperatorType {
            return values().firstOrNull { it.symbol == symbol }
                ?: throw IllegalArgumentException("Invalid format")
        }
    }
}
