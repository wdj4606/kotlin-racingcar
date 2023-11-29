package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "김용수", age = 37, nickname = "Daniel")
        assertThat(actual.name).isEqualTo("김용수")
        assertThat(actual.age).isEqualTo(37)
        assertThat(actual.nickname).isEqualTo("Daniel")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "김용수", age = 37, nickname = null)
        assertThat(actual.name).isEqualTo("김용수")
        assertThat(actual.age).isEqualTo(37)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person("김용수", 37)
        assertThat(actual.name).isEqualTo("김용수")
        assertThat(actual.age).isEqualTo(37)
        assertThat(actual.nickname).isEqualTo("김용수")
    }

    @Test
    fun `동등성 비교`() {
        val person1 = Person("김용수", 37, "대니얼")
        val person2 = Person("김용수", 37, "대니얼")
        assertThat(person1 === person2).isFalse()
        assertThat(person1 == person2).isTrue()
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person = Person("김용수", 37, "대니얼")
        val actual = person.copy(nickname = "Daniel")

        assertThat(person.name).isEqualTo(actual.name)
        assertThat(person.age).isEqualTo(actual.age)
        assertThat(person.nickname).isNotEqualTo("Daniel")
    }
}
