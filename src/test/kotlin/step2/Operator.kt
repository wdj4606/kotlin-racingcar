package step2

enum class Operator(
    val symbol: String,
    val operator: (Double, Double) -> Double
) {
    ADD("+", { a, b -> a + b }),
    SUB("-", { a, b -> a - b }),
    MUL("*", { a, b -> a * b }),
    DIV("/", { a, b -> a / b }),
    ;

    fun apply(num1: Double, num2: Double): Double = operator(num1, num2)

    companion object {
        fun symbolOf(symbol: String): Operator {
            return values()
                .firstOrNull { it.symbol == symbol }
                ?: throw IllegalArgumentException("Invalid operator symbol: '$symbol'")
        }
    }
}
