package step2

object Calculator {

    private fun Double.plus(operand: Double) = this + operand
    private fun Double.minus(operand: Double) = this - operand
    private fun Double.multiply(operand: Double) = this * operand
    private fun Double.divide(operand: Double) = this / operand
    fun calculate(operand: Double, total: Double, operator: String): Double {
        return when (operator) {
            "+" -> total.plus(operand)
            "-" -> total.minus(operand)
            "*" -> total.multiply(operand)
            "/" -> total.divide(operand)
            else -> throw IllegalArgumentException("연산자가 올바른 형식이 아닙니다.(+,-,*,/ 만 가능)")
        }
    }
}

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        throw IllegalArgumentException("입력값은 필수입니다.")
    }
    val inputList: List<String> = args[0].split(" ")

    var total = inputList[0].toDouble()
    val numberElements = inputList.filterIndexed { index, _ -> index % 2 == 0 && index != 0 }
    val operatorElements = inputList.filterIndexed { index, _ -> index % 2 != 0 }
    if (operatorElements.size != numberElements.size) throw IllegalArgumentException("올바른 식이 아닙니다.")

    for (i in numberElements.indices) {
        val operator = operatorElements[i]
        val operand = numberElements[i].toDoubleOrNull() ?: throw IllegalArgumentException("피연산자가 올바른 형식이 아닙니다.")
        total = Calculator.calculate(operand, total, operator)
    }
    println(total)
}
