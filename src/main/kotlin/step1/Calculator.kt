package step1

object Calculator {
    fun calculate(input: String): Long {

        val split = input.split(" ")

        var result: Long = split[0].toLongOrNull() ?: throw IllegalArgumentException()

        for (i in 1 until split.size step 2) {
            val operand: Long = split[i + 1].toLongOrNull() ?: throw IllegalArgumentException()
            result = operate(split[i], result, operand)
        }

        return result
    }

    private fun operate(operator: String, op1: Long, op2: Long): Long {
        return when (operator) {
            "+" -> op1 + op2
            "-" -> op1 - op2
            "*" -> op1 * op2
            "/" -> op1 / op2
            else -> throw IllegalArgumentException()
        }
    }
}
