object FormulaParser {
    const val ERR_NULL_OR_EMPTY = "수식은 null이거나 비어있을 수 없음"
    const val ERR_CHAR_VALID = "수식에 잘못된 문자가 포함됨"
    const val ERR_OPERATOR_PAIR = "연산자와 숫자 쌍이 맞지 않음"
    const val ERR_NUMBER_STRING = "수식에 있는 항목을 숫자로 변환 못함"
    const val ERR_OPERATOR_STRING = "잘못된 연산자가 발견됨"
    const val ERR_DIVIDE_BY_ZERO = "0으로 나눔"

    fun execute(formula: String?): List<String> {
        require(!formula.isNullOrEmpty()) { ERR_NULL_OR_EMPTY }
        val trimmedFormula = formula.trim()
        require(trimmedFormula.isNotEmpty()) { ERR_NULL_OR_EMPTY }

        checkCharValid(trimmedFormula)
        val splits = splitByOperator(trimmedFormula)
        checkSplitStringOrder(splits)
        checkDivisionByZero(splits)
        return splits
    }

    private fun checkCharValid(formula: String) {
        val regex = Regex(Operator.validPattern)
        require(regex.matches(formula)) { ERR_CHAR_VALID }
    }

    private fun splitByOperator(formula: String): List<String> {
        val regex = Regex(Operator.splitPattern)
        return formula.split(regex).map { it.trim() }.filter { it.isNotEmpty() }
    }

    private fun convertNumber(split: String): Double {
        return try {
            split.toDouble()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERR_NUMBER_STRING)
        }
    }

    private fun checkOperator(split: String) {
        val operator = Operator.fromSymbol(split)
        require(operator in listOf(Operator.PLUS, Operator.MINUS, Operator.MULTIPLY, Operator.DIVIDE)) { ERR_OPERATOR_STRING }
    }

    private fun checkSplitStringOrder(splits: List<String>) {
        require(splits.size % 2 != 0) { ERR_OPERATOR_PAIR }

        try {
            trySplitsConvert(splits)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(ERR_OPERATOR_PAIR)
        }
    }

    private fun trySplitsConvert(splits: List<String>) {
        splits.mapIndexed { index, value ->
            if (index % 2 == 1) checkOperator(value)
            else convertNumber(value)
        }
    }

    private fun checkDivisionByZero(splits: List<String>) {
        for (i in splits.indices) {
            if (i % 2 == 1 && splits[i] == "/" && i + 1 < splits.size && splits[i + 1].toDouble() == 0.0) {
                throw IllegalArgumentException(ERR_DIVIDE_BY_ZERO)
            }
        }
    }
}
