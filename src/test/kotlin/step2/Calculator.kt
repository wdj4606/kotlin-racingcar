package step2

import java.lang.IllegalArgumentException

enum class Operator {
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE
}

object Calculator {
    fun calculateExpression(expression: String?): Double {

        val exp = validateExpression(expression)

        splitExpression(exp).let { (operands, operators) ->
            var result = operands.first().toDouble()

            for (i in 1 until operands.size) {
                when (operators[i - 1]) {
                    Operator.PLUS -> result += operands[i].toDouble()
                    Operator.MINUS -> result -= operands[i].toDouble()
                    Operator.MULTIPLY -> result *= operands[i].toDouble()
                    Operator.DIVIDE -> result /= operands[i].toDouble()
                }
            }
            // println(result)
            return result
        }
    }

    fun splitExpression(expression: String): Pair<List<String>, List<Operator>> {
        val operands = mutableListOf<String>()
        val operators = mutableListOf<Operator>()
        val parts = expression.split(Regex("[+\\-*/]"))

        for (char in expression) {
            when (char) {
                '+', '-', '*', '/' -> {
                    operators.add(
                        when (char) {
                            '+' -> Operator.PLUS
                            '-' -> Operator.MINUS
                            '*' -> Operator.MULTIPLY
                            '/' -> Operator.DIVIDE
                            else -> throw IllegalArgumentException("Unsupported operator")
                        }
                    )
                }
            }
        }
        for (part in parts) {
            if (part.isNotBlank()) {
                operands.add(part.trim())
            }
        }

        // 피연산자의 개수는 연산자의 개수보다 1개 많아야 함
        if (operands.size - operators.size != 1) {
            throw IllegalArgumentException("올바른 표현식이 아닙니다.")
        }
        return Pair(operands, operators)
    }

    fun validateExpression(expression: String?): String {

        // 시작하기 전 공백 제거
        val expNoBlank = expression?.replace("\\s".toRegex(), "")

        // 1. 문자열이 null이거나 공백인지 확인
        if (expNoBlank.isNullOrBlank()) {
            throw IllegalArgumentException("공백과 null은 입력할 수 없습니다.")
        }

        // 2. 사칙 연산 기호와 숫자 이외의 문자가 있는지 확인
        val validCharacters = Regex("[+\\-*/0-9.]")
        if (!expNoBlank.all { it.toString().matches(validCharacters) }) {
            throw IllegalArgumentException("부적절한 문자가 포함되어 있습니다.")
        }

        // 3. 숫자에 소수점이 두 개 이상 있는지 확인
        val parts = expNoBlank.split(Regex("[+\\-*/]"))
        for (part in parts) {
            if (part.count { it == '.' } > 1) {
                throw IllegalArgumentException("정상적인 소수가 아닙니다.")
            }
        }

        // 4. 사칙 연산 기호가 연속으로 나오는 경우 체크 (소수점 포함)
        val consecutiveOperators = Regex("[+\\-*/.]{2,}")
        if (consecutiveOperators.containsMatchIn(expNoBlank)) {
            throw IllegalArgumentException("기호( +, -, /, *, . )는 연속으로 나올 수 없습니다.")
        }

        // 5. 0으로 나누는 경우가 있는지 확인
        if (expNoBlank.contains("/0")) {
            throw IllegalArgumentException("0으로 나눌 수는 없습니다.")
        }

        return expNoBlank
    }
}
