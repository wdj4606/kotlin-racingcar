object Calculator {
    fun execute(formula: String?): Double {
        val calcItems = FormulaParser.execute(formula)

        var result = calcItems[0].toDouble()

        for (i in 1 until calcItems.size step 2) {
            val operator = calcItems[i]
            val nextNumber = calcItems[i + 1].toDouble()

            result = when (operator) {
                FormulaParser.PLUS -> result + nextNumber
                FormulaParser.MINUS -> result - nextNumber
                FormulaParser.MULTIPLY -> result * nextNumber
                FormulaParser.DIVIDE -> result / nextNumber
                else -> throw IllegalArgumentException("Unknown operator: $operator")
            }
        }

        return result
    }
}
