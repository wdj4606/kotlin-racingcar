package step2

enum class Operator(
    private val operationSymbol: String,
    private val operator: (Long, Long) -> Long
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b });

    fun calculate(value1: Long, value2: Long): Long {
        return this.operator(value1, value2)
    }

    companion object {
        fun of(operationSymbol: String): Operator {
            return values().find { it.operationSymbol == operationSymbol }
                ?: throw IllegalArgumentException("연산자가 올바른 형식이 아닙니다.(+,-,*,/ 만 가능)")
        }
    }
}
