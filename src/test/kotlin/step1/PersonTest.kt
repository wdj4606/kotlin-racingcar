package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "박동근", age = 31, nickname = "루트")
        assertThat(actual.name).isEqualTo("박동근")
        assertThat(actual.age).isEqualTo(31)
        assertThat(actual.nickname).isEqualTo("루트")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "박동근", age = 31, nickname = null)
        assertThat(actual.name).isEqualTo("박동근")
        assertThat(actual.age).isEqualTo(31)
        assertThat(actual.nickname).isNull()
        // val result = actual.nickname ?: throw IllegalAccessException()
        // println(result)
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "박동근", age = 31)
        assertThat(actual.name).isEqualTo("박동근")
        assertThat(actual.age).isEqualTo(31)
        assertThat(actual.nickname).isEqualTo("박동근")
    }

    @Test
    fun `동등성 비교`() {
        val person1 = Person(name = "박동근", age = 31, nickname = "루트")
        val person2 = Person(name = "박동근", age = 31, nickname = "루트")

        assertThat(person1).isEqualTo(person2)
        assertThat(person1 == person2).isTrue() // 값 비교
        assertThat(person1 === person2).isFalse() // 주솟값 비교
    }

    @Test
    fun `복사`() {
        val person = Person(name = "박동근", age = 31, nickname = "루트")
        val actual = person.copy(nickname = "박동근")

        assertThat(actual.name).isEqualTo("박동근")
        assertThat(actual.age).isEqualTo(31)
        assertThat(actual.nickname).isEqualTo("박동근")
    }
}
