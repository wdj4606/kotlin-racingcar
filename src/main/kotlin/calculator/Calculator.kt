package calculator

class Calculator {

    fun calc(format: String): Double {
        require(format.isNotBlank()) { "blank" }

        val tokens = format.split(" ").toMutableList()

        var index = 0
        var result: Double = tokens[index].toDouble()

        while (index + 2 < tokens.size) {
            val operatorType = OperatorType.fromSymbol(tokens[++index])
            val operand = tokens[++index].toDouble()
            result = operatorType.calc(result, operand)
        }
        return result
    }
}
