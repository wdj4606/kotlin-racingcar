package step1

enum class OperatorType(
    private val operator: (Long, Long) -> Long
) {
    PLUS({ op1, op2 -> op1 + op2 }),
    MINUS({ op1, op2 -> op1 - op2 }),
    TIMES({ op1, op2 -> op1 * op2 }),
    DIVIDE({ op1, op2 -> op1 / op2 });

    companion object {
        fun operate(operator: String, op1: Long, op2: Long): Long {
            return when (operator) {
                "+" -> PLUS.operator(op1, op2)
                "-" -> MINUS.operator(op1, op2)
                "*" -> TIMES.operator(op1, op2)
                "/" -> DIVIDE.operator(op1, op2)
                else -> throw IllegalArgumentException()
            }
        }
    }
}
