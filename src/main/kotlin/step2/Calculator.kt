package step2

import java.math.BigDecimal

object Calculator {

    fun calculate(expression: String?): Double {
        require(!expression.isNullOrBlank()) { ExceptionType.EMPTY_EXPRESSION }

        val tokens = expression.split(" ")
        require(tokens.size % 2 != 0) { ExceptionType.INVALID_EXPRESSION }

        var result = BigDecimal(tokens[0].toDoubleOrNull() ?: throw IllegalArgumentException(ExceptionType.EMPTY_EXPRESSION))

        for (i in 1 until tokens.size step 2) {
            val operator = tokens[i]
            val nextNumber = BigDecimal(tokens[i + 1].toDoubleOrNull() ?: throw IllegalArgumentException(ExceptionType.EMPTY_EXPRESSION))

            val operation = Operator.from(operator)
            result = operation.apply(result, nextNumber)
        }

        return result.toDouble()
    }
}
