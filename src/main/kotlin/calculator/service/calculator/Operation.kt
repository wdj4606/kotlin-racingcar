package calculator.service.calculator

interface Operation {
    fun calculate(left: Double, right: Double): Double
}
