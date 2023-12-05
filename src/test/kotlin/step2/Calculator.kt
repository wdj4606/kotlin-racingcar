package step2

import step2.InputValidator.requireNotNullOrBlank

object Calculator {
    fun calc(expression: String?): Double {
        val tokens = requireNotNullOrBlank(expression)
            .split(" ".toRegex())

        val firstOperand = parseOperand(tokens.first())

        return tokens
            .drop(1)
            .chunked(2) {
                val operator = parseOperator(it.getOrNull(0))
                val operand = parseOperand(it.getOrNull(1))
                operator to operand
            }
            .fold(firstOperand) { acc, (operator, operand) ->
                operator.apply(acc, operand)
            }
    }
    private fun parseOperator(token: String?): Operator {
        return requireNotNull(token).let {
            Operator.symbolOf(it)
        }
    }

    private fun parseOperand(token: String?): Double {
        return requireNotNull(token).let {
            it.toDoubleOrNull() ?: throw IllegalArgumentException("Invalid operand: $token")
        }
    }
}
