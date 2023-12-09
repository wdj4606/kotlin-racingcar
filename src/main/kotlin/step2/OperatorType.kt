package step2

enum class OperatorType(
    private val symbol: String,
    private val operator: (Long, Long) -> Long
) {
    PLUS("+", { op1, op2 -> op1 + op2 }),
    MINUS("-", { op1, op2 -> op1 - op2 }),
    TIMES("*", { op1, op2 -> op1 * op2 }),
    DIVIDE("/", { op1, op2 -> op1 / op2 });

    companion object {
        private val symbolMap: Map<String, OperatorType> = values().associateBy { it.symbol }

        fun operate(operator: String, op1: Long, op2: Long): Long {
            val operatorType = symbolMap[operator] ?: throw IllegalArgumentException()
            return operatorType.operator(op1, op2)
        }
    }
}
