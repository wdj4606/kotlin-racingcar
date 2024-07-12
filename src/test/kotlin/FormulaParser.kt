object FormulaParser {
    const val ERR_NULL_OR_EMPTY = "수식은 null이거나 비어있을 수 없음"
    const val ERR_OPERATOR_PAIR = "연산자와 숫자 쌍이 맞지 않음"
    const val ERR_NUMBER_STRING = "수식에 있는 항목을 숫자로 변환 못함"
    const val ERR_DIVIDE_BY_ZERO = "0으로 나눔"

    fun execute(formula: String?): List<String> {
        require(!formula.isNullOrEmpty()) { ERR_NULL_OR_EMPTY }
        val trimmedFormula = formula.trim()
        require(trimmedFormula.isNotEmpty()) { ERR_NULL_OR_EMPTY }

        val splits = splitByOperator(trimmedFormula)
        checkSplitCount(splits)
        trySplitsConvert(splits)
        checkDivisionByZero(splits)
        return splits
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

    private fun checkSplitCount(splits: List<String>) {
        require(splits.size % 2 != 0) { ERR_OPERATOR_PAIR }
    }

    private fun trySplitsConvert(splits: List<String>) {
        splits.mapIndexed { index, value ->
            if (index % 2 == 1) Operator.fromSymbol(value)
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
