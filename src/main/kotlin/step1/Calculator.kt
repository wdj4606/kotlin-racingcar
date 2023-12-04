package step1

class Calculator {
    fun calculate(input: String): Long {

        val split = input.split(" ")

        var result: Long = split[0].toLong()

        for (i in 1 until split.size step 2) {
            val operand: Long = split[i + 1].toLongOrNull() ?: throw IllegalArgumentException()
            result = operate(split[i], result, operand)
        }

        return result
    }

    private fun operate(operator: String, num1: Long, num2: Long): Long {
        return when (operator) {
            "+" -> plus(num1, num2)
            "-" -> minus(num1, num2)
            "*" -> times(num1, num2)
            "/" -> divide(num1, num2)
            else -> throw IllegalArgumentException()
        }
    }

    private fun plus(num1: Long, num2: Long): Long {
        return num1 + num2
    }

    private fun minus(num1: Long, num2: Long): Long {
        return num1 - num2
    }

    private fun times(num1: Long, num2: Long): Long {
        return num1 * num2
    }

    private fun divide(num1: Long, num2: Long): Long {
        return num1 / num2
    }
}
