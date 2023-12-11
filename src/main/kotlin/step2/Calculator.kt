package step2

object Calculator {
    fun calculate(inputList: Array<String>): Long {
        require(inputList.isNotEmpty()) { "입력값은 필수입니다." }
        var splitList = inputList[0].split(" ")
        var total = splitList[0].toLongOrNull() ?: throw IllegalArgumentException("첫 입력값은 숫자여야 합니다.")

        val numberElements = splitList.filterIndexed { index, _ -> index % 2 == 0 && index != 0 }
        val operatorElements = splitList.filterIndexed { index, _ -> index % 2 != 0 }
        if (operatorElements.size != numberElements.size) throw IllegalArgumentException("올바른 식이 아닙니다.")

        numberElements.indices.forEach { i ->
            val operator = operatorElements[i]
            val operand = numberElements[i].toLongOrNull() ?: throw IllegalArgumentException("피연산자가 올바른 형식이 아닙니다.")
            total = this.operate(total, operand, operator)
        }
        return total
    }
    private fun operate(operand: Long, total: Long, operator: String): Long {
        return Operator.of(operator).calculate(operand, total)
    }
}
