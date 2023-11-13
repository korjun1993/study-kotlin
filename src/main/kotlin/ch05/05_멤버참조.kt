package ch05

/**
 * 코틀린에서는 자바 8과 마찬가지로 함수를 값으로 바꿀 수 있다.
 * 이 때 이중 콜론(::)을 사용한다.
 * ::를 사용하는 식을 멤버 참조(member reference)라고 부른다.
 * ::는 클래스 이름과 여러분이 참조하려는 멤버(프로퍼티나 메서드) 이름 사이에 위치한다.
 * 최상위에 선언된 함수나 프로퍼티를 참조할 수도 있다.
 */

fun salute() = println("Salute!")

fun main() {
    val getAge = { person: Person -> person.age }
    val getAgeUsingMemberReference = Person::age
    run(::salute)
}
