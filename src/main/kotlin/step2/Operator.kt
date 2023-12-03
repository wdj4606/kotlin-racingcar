package step2

interface OperatorExecutor {
    fun apply(x: Int, y: Int): Int
}

enum class Operator(val symbol: String) : OperatorExecutor {

    PLUS("+") {
        override fun apply(x: Int, y: Int): Int {
            return x.plus(y)
        }
    },
    MINUS("-") {
        override fun apply(x: Int, y: Int): Int {
            return x.minus(y)
        }
    },
    MULTIPLY("*") {
        override fun apply(x: Int, y: Int): Int {
            return x.times(y)
        }
    },
    DIVIDE("/") {
        override fun apply(x: Int, y: Int): Int {
            return x.div(y)
        }
    };

    companion object {
        fun from(symbol: String): Operator {
            return values().firstOrNull { it.symbol == symbol }
                ?: throw IllegalArgumentException("지원하지 않는 연산자입니다.")
        }
    }
}
