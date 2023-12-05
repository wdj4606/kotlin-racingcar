package step2

object Calculator {
    fun calc(expression: String?): Double {
        require(!expression.isNullOrBlank()) { "Expression must not be null" }

        val tokens = expression.split(" ")

        val firstOperand = parseOperand(tokens.first())

        return tokens
            .drop(1)
            .chunked(2) {
                val operator = parseOperator(it[0])
                val operand = parseOperand(it[1])
                operator to operand
            }
            .fold(firstOperand) { acc, (operator, operand) ->
                operator.apply(acc, operand)
            }
    }

    private fun parseOperator(token: String): Operator {
        return token.let {
            Operator.symbolOf(it)
        }
    }

    private fun parseOperand(token: String): Double {
        return token.let {
            it.toDouble()
        }
    }
}
