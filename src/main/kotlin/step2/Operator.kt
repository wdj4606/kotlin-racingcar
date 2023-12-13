package step2

enum class Operator(val symbol: String, val op: (Int, Int) -> Int) {

    PLUS("+", { x, y -> x + y }),
    MINUS("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y });

    companion object {
        fun from(symbol: String): Operator {
            return values().firstOrNull { it.symbol == symbol }
                ?: throw IllegalArgumentException("지원하지 않는 연산자입니다.")
        }
    }
}
