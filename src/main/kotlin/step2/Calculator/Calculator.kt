package step2.Calculator

object Calculator {
    fun calculate(input: String): Int {

        require(!input.isNullOrBlank()) { "입력값이 Null or Empty 입니다" }

        val string = input.split(" ")

        var result = string[0].toInt()

        var index = 2

        while (index < string.size) {
            val operator = string[index - 1]

            require(isOperator(operator)) {"사칙 연산 기호가 아닙니다."}

            val operand = string[index].toInt()

            when (operator) {
                Operator.PLUS.operator -> result += operand
                Operator.MINUS.operator -> result -= operand
                Operator.MULTIPLY.operator -> result *= operand
                Operator.DIVIDE.operator -> result /= operand
            }

            index += 2
        }

        return result
    }

    private fun isOperator(string: String): Boolean {
        return string.matches(Regex("[+\\-*/]"))
    }

    enum class Operator(val operator: String) {
        PLUS("+"),
        MINUS("-"),
        MULTIPLY("*"),
        DIVIDE("/")
        ;
    }

}
