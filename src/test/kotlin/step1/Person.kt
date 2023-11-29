package step1

data class Person(val name: String, val age: Int, var nickname: String? = name) {
    fun isOlderThan(other: Person): Boolean? {
        return if (age > other.age) true else null
    }
}
