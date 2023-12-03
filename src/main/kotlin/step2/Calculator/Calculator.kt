package step2.Calculator

class Calculator {
    fun calculate(input: String): Int {

        if (input.isNullOrEmpty()) {
            throw IllegalArgumentException("입력값이 Null or Empty 입니다.")
        }

        val string = input.split(" ")

        var result = string[0].toInt()

        var index = 2

        while (index < string.size) {
            val operator = string[index - 1]

            if (!isOperator(operator)) {
                throw IllegalArgumentException("사칙 연산 기호가 아닙니다.")
            }

            val operand = string[index].toInt()

            when (operator) {
                "+" -> result += operand
                "-" -> result -= operand
                "*" -> result *= operand
                "/" -> result /= operand
            }
            
            index += 2
        }

        return result
    }

    private fun isOperator(string: String): Boolean {
        return string.matches(Regex("[+\\-*/]"))
    }

    private fun CharSequence?.isNullOrEmpty(): Boolean {
        return this == null || this.isEmpty()
    }
}
