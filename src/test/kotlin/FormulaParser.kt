object FormulaParser {
    const val PLUS = "+"
    const val MINUS = "-"
    const val MULTIPLY = "*"
    const val DIVIDE = "/"

    private const val REG_VALID_PATTERN = "[0-9 +\\-*/.]*"
    private const val REG_SPLIT_PATTERN = "(?<=[-+*/])|(?=[-+*/])"

    const val ERR_NULL_OR_EMPTY = "수식은 null이거나 비어있을 수 없음"
    const val ERR_CHAR_VALID = "수식에 잘못된 문자가 포함됨"
    const val ERR_OPERATOR_PAIR = "연산자와 숫자 쌍이 맞지 않음"
    const val ERR_NUMBER_STRING = "수식에 있는 항목을 숫자로 변환 못함"
    const val ERR_OPERATOR_STRING = "잘못된 연산자가 발견됨"
    const val ERR_DIVIDE_BY_ZERO = "0으로 나눔"

    fun execute(formula: String?): List<String> {
        if (formula == null) {
            throw IllegalArgumentException(ERR_NULL_OR_EMPTY)
        }
        val trimmedFormula = formula.trim()
        if (trimmedFormula.isEmpty()) {
            throw IllegalArgumentException(ERR_NULL_OR_EMPTY)
        }

        checkCharValid(trimmedFormula)
        val splits = splitByOperator(trimmedFormula)
        checkSplitStringOrder(splits)
        return splits
    }

    fun checkCharValid(formula: String) {
        val regex = Regex(REG_VALID_PATTERN)
        if (!regex.matches(formula))
            throw IllegalArgumentException(ERR_CHAR_VALID)
    }

    fun splitByOperator(formula: String): List<String> {
        val regex = Regex(REG_SPLIT_PATTERN)
        return formula.split(regex).map { it.trim() }.filter { it.isNotEmpty() }
    }

    fun convertNumber(split: String): Double {
        return try {
            split.toDouble()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERR_NUMBER_STRING)
        }
    }

    fun checkOperator(split: String) {
        if (split !in listOf(PLUS, MINUS, MULTIPLY, DIVIDE))
            throw IllegalArgumentException(ERR_OPERATOR_STRING)
    }

    fun checkSplitStringOrder(splits: List<String>) {
        if (splits.size % 2 == 0) {
            throw IllegalArgumentException(ERR_OPERATOR_PAIR)
        }

        try {
            splits.mapIndexed { index, value ->
                if (index % 2 == 1) checkOperator(value)
                else convertNumber(value)
            }
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(ERR_OPERATOR_PAIR)
        }
    }

    fun checkDivisionByZero(splits: List<String>) {
        for (i in splits.indices) {
            if (i % 2 == 1 && splits[i] == "/" && i + 1 < splits.size && splits[i + 1].toDouble() == 0.0) {
                throw IllegalArgumentException(ERR_DIVIDE_BY_ZERO)
            }
        }
    }
}
