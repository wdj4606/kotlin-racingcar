import java.math.BigDecimal
import java.math.RoundingMode

object Calculator {
    fun execute(formula: String?): Double {
        val calcItems = FormulaParser.execute(formula)

        var result = BigDecimal(calcItems[0])

        for (i in 1 until calcItems.size step 2) {
            val operator = calcItems[i]
            val nextNumber = BigDecimal(calcItems[i + 1])

            result = when (operator) {
                FormulaParser.PLUS -> result + nextNumber
                FormulaParser.MINUS -> result - nextNumber
                FormulaParser.MULTIPLY -> result * nextNumber
                FormulaParser.DIVIDE -> result.divide(nextNumber, 10, RoundingMode.HALF_UP)
                else -> throw IllegalArgumentException("Unknown operator: $operator")
            }
        }

        return result.toDouble()
    }
}
