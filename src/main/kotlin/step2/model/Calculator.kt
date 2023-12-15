package step2.model

object Calculator {
    private fun checkValidFormula(formula: String?): List<String> {
        require(!formula.isNullOrBlank()) { "formula is null or blank" }

        val splitFormulas = formula.split(" ")
        if (splitFormulas.size % 2 === 0) throw IllegalArgumentException("formula is incorrect")

        return splitFormulas
    }

    private fun calculateSegment(operand1: Int, operator: String, operand2: Int): Int {
        return OperatorType.of(operator).calculate(operand1, operand2)
    }

    fun calculate(formula: String?): Int {
        val splitFormulas = checkValidFormula(formula)

        var result = splitFormulas[0].toInt()
        var index = 1

        while (index < splitFormulas.size) {
            val operator = splitFormulas[index]
            val operand = splitFormulas[index + 1].toInt()

            result = calculateSegment(result, operator, operand)
            index += 2
        }

        return result
    }
}