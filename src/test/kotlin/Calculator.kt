import java.math.BigDecimal
import java.math.RoundingMode

object Calculator {
    fun execute(formula: String?): Double {
        val calcItems = FormulaParser.execute(formula)

        var result = BigDecimal(calcItems[0])

        for (i in 1 until calcItems.size step 2) {
            val operator = calcItems[i]
            val nextNumber = BigDecimal(calcItems[i + 1])

            result = calculate(result, nextNumber, operator)
        }

        return result.toDouble()
    }

    fun calculate(a: BigDecimal, b: BigDecimal, operator: String): BigDecimal {
        return when (operator) {
            FormulaParser.PLUS -> a + b
            FormulaParser.MINUS -> a - b
            FormulaParser.MULTIPLY -> a * b
            FormulaParser.DIVIDE -> a.divide(b, 10, RoundingMode.HALF_UP)
            else -> throw IllegalArgumentException("Unknown operator: $operator")
        }
    }
}
