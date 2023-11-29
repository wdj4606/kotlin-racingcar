package step1

import Person
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {
    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("원동재", 32, "피터"),
            Person("원동재", 32, nickname = "피터"),
            Person(name = "원동재", nickname = "피터", age = 32)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("원동재")
            assertThat(it.age).isEqualTo(32)
            assertThat(it.nickname).isEqualTo("피터")
        }
    }

    @Test
    fun `nullable types`() {
        val person = Person("원동재", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("원동재") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `default arguments`() {
        val person = Person("원동재")
        assertAll(
            { assertThat(person.name).isEqualTo("원동재") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `data classes`() {
        val person1 = Person("원동재", 32, "피터")
        val person2 = Person("원동재", 32, "피터")
        val person3 = person1.copy()

        assertThat(person1).isEqualTo(person2)
        assertThat(person3).isEqualTo(person2)
    }
}
