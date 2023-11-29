package step1

// val getter 제공
// var getter, setter 제공
// property 로 제공되는 친구는 생성자가 제공됨.
data class Person(val name: String, val age: Int?, var nickname: String? = name)
