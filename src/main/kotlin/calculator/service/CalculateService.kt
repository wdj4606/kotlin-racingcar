package calculator.service

import calculator.service.calculator.Addition
import calculator.service.calculator.Division
import calculator.service.calculator.Multiplication
import calculator.service.calculator.Subtraction

class CalculateService {
    private val operations = mapOf(
        "+" to Addition(),
        "-" to Subtraction(),
        "*" to Multiplication(),
        "/" to Division()
    )

    fun calculate(input: String): String {
        if (input.isEmpty()) {
            throw IllegalArgumentException("input error")
        }

        val expressions = input.split(" ")
        if (expressions.size % 2 == 0) {
            throw IllegalArgumentException("input error")
        }

        var result = expressions[0].toDoubleOrNull() ?: throw IllegalArgumentException("input error")
        for (i in 1 until expressions.size step 2) {
            val operation = operations[expressions[i]] ?: throw IllegalArgumentException("input error")
            val right = expressions[i + 1].toDoubleOrNull() ?: throw IllegalArgumentException("input error")
            result = operation.calculate(result, right)
        }

        return result.toString()
    }
}
