package step2

class DivisionByZeroException : IllegalArgumentException("0으로 나눌 수 없습니다")
class InvalidOperatorException(operator: String) : IllegalArgumentException("잘못된 연산자: $operator")
class InvalidNumberException(number: String) : IllegalArgumentException("잘못된 숫자: $number")
class EmptyExpressionException : IllegalArgumentException("수식은 null이거나 공백일 수 없습니다")
class InvalidExpressionException : IllegalArgumentException("잘못된 수식 형식입니다")
