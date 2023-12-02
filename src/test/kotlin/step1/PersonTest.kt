package step1

import Person
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "신승민", nickname = "해리", age = 27)
        assertThat(actual.name).isEqualTo("신승민")
        assertThat(actual.age).isEqualTo(27)
        assertThat(actual.nickname).isEqualTo("해리")
    }

    @Test
    fun `널 타입`() {
        val actual = Person("신승민", 27, null)
        assertThat(actual.name).isEqualTo("신승민")
        assertThat(actual.age).isEqualTo(27)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person("신승민", 27)
        assertThat(actual.name).isEqualTo("신승민")
        assertThat(actual.age).isEqualTo(27)
        assertThat(actual.nickname).isEqualTo("신승민")
    }

    @Test
    fun `동등성 비교`() {
        val person1 = Person("신승민", 27, "해리")
        val person2 = Person("신승민", 27, "해리")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person = Person("신승민", 27, "해리")
        val actual = person.copy(nickname = "해뤼")

        assertThat(actual.nickname).isEqualTo("해뤼")
    }
}
