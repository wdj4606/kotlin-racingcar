package calculator.main

import calculator.service.CalculateService

fun main(args: Array<String>) {

    println("input text: ")
    val text: String = readlnOrNull() ?: throw IllegalArgumentException("input is null")
    val result = CalculateService().calculate(text)
    println("result: $result")
}
