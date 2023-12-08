package step2

enum class Operators(val symbol: String) {
    PLUS("+") {
        override fun calc(x: Double, y: Double): Double = x + y
    },
    MINUS("-") {
        override fun calc(x: Double, y: Double): Double = x - y
    },
    MULTIPLY("*") {
        override fun calc(x: Double, y: Double): Double = x * y
    },
    DIVIDE("/") {
        override fun calc(x: Double, y: Double): Double = x / y
    };

    abstract fun calc(x: Double, y: Double): Double
    companion object {
        fun operate(data1: Double, data2: Double, operator: String): Double {
            val op = values().find { it.symbol == operator }
            return op?.calc(data1, data2) ?: throw IllegalArgumentException("Invalid operator: $operator")
        }
    }
}
