package step2

enum class Operator {
    ADD { override fun apply(a: Double, b: Double): Double = a + b },
    SUBTRACT { override fun apply(a: Double, b: Double): Double = a - b },
    MULTIPLY { override fun apply(a: Double, b: Double): Double = a * b },
    DIVIDE {
        override fun apply(a: Double, b: Double): Double {
            require(b != 0.0) { throw DivisionByZeroException() }
            return a / b
        }
    };

    abstract fun apply(a: Double, b: Double): Double

    companion object {
        fun from(symbol: String): Operator {
            return when (symbol) {
                "+" -> ADD
                "-" -> SUBTRACT
                "*" -> MULTIPLY
                "/" -> DIVIDE
                else -> throw InvalidOperatorException(symbol)
            }
        }
    }
}
