import java.math.BigDecimal

object Calculator {
    fun execute(formula: String?): Double {
        val calcItems = FormulaParser.execute(formula)

        var result = BigDecimal(calcItems[0])

        for (i in 1 until calcItems.size step 2) {
            val operator = Operator.fromSymbol(calcItems[i])
            val nextNumber = BigDecimal(calcItems[i + 1])

            if (operator == null) continue

            result = operator.operation(result, nextNumber)
        }

        return result.toDouble()
    }
}
