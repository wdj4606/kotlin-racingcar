package step2

object Calculator {

    fun calculate(expression: String?): Double {
        if (expression.isNullOrBlank()) throw EmptyExpressionException()

        val tokens = expression.split(" ")
        if (tokens.size % 2 == 0) throw InvalidExpressionException()

        var result = tokens[0].toDoubleOrNull() ?: throw InvalidNumberException(tokens[0])

        for (i in 1 until tokens.size step 2) {
            val operator = tokens[i]
            val nextNumber = tokens[i + 1].toDoubleOrNull() ?: throw InvalidNumberException(tokens[i + 1])

            val operation = Operator.from(operator)
            result = operation.apply(result, nextNumber)
        }

        return result
    }
}
