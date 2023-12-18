//문자열 입력받음
//사칙연산 순서 X


public class Calculator {

    //더하기
    //뺄셈
    //곱셈
    //나눗셈

    public fun drive(argument: String): Double {
        val (numberList, operatorList) = preProcess(argument)
        return operate(numberList, operatorList)
    }

    private fun preProcess(argument: String): Pair<MutableList<Int>, MutableList<Char>> {
        val argument : String = argument.replace(" ","");
        if (argument.isEmpty()) {
            throw IllegalArgumentException("there is no input")
        }

        val numberList = mutableListOf<Int>()
        val operatorList = mutableListOf<Char>()
        var number = 0
        for (token in argument) {
            when {
                Regex("[0-9]").matches(token.toString()) -> number = number * 10 + (token - '0')
                Regex("[+\\-*/]").matches(token.toString()) -> {
                    numberList.add(number)
                    operatorList.add(token)
                    number = 0
                }
                else -> throw IllegalArgumentException("only number and operator are allowed")
            }
        }
        numberList += number
        return Pair(numberList, operatorList)
    }

    private fun operate(numberList: MutableList<Int>, operatorList: MutableList<Char>): Double {
        var result : Double = numberList[0].toDouble()
        for (i in 1 until numberList.size) {
            result = when (operatorList[i - 1]) {
                '+' -> result + numberList[i]
                '-' -> result - numberList[i]
                '*' -> result * numberList[i]
                '/' -> result / numberList[i]
                else -> throw IllegalArgumentException("only +, -, *, / are allowed")
            }
        }
        return result
    }
}

fun main() {
    val calculator = Calculator()
    val argument = readln()
    println(calculator.drive(argument))
}
