package step1

import Person
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "조대현", age = 20, nickname = "danny")
        assertThat(actual.name).isEqualTo("조대현")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("danny")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "조대현", age = 20, nickname = null)
        assertThat(actual.name).isEqualTo("조대현")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "조대현", age = 20)
        assertThat(actual.name).isEqualTo("조대현")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("조대현")
    }

    @Test
    fun `동등성 비교`() {
        val person1 = Person(name = "조대현", age = 20, nickname = "danny")
        val person2 = Person(name = "조대현", age = 20, nickname = "danny")

        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person1 = Person(name = "조대현", age = 20, nickname = "danny")
        val person2 = person1.copy(nickname = "danny2")

        assertThat(person2.name).isEqualTo("조대현")
        assertThat(person2.age).isEqualTo(20)
        assertThat(person2.nickname).isEqualTo("danny2")
    }
}
