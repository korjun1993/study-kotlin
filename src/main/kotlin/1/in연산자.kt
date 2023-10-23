package `1`

/**
 * in 연산자를 사용해 어떤 값이 범위에 속하는지 검사할 수 있다.
 * 반대로 !in을 사용하면 어떤 값이 범위에 속하지 않는지 검사할 수 있다.
 */

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

fun isNotDigit(c: Char) = c !in '0'..'9' // !('0' <= c && c <= '9')로 변환된다.

/**
 * in, !in 연산자를 when 식에서 사용해도 된다.
 */
fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter"
    else -> "I don't know..."
}

/**
 * 범위는 문자에만 국한되지 않는다. 비교가 가능한 클래스(Comparable 인터페이스를 구현한 클래스)라면 그 클래스의 인스턴스 객체를 사용해 범위를 만들 수 있다.
 * 하지만, Comparable을 사용하는 범위의 경우 그 범위 내의 모든 객체를 항상 이터레이션하지는 못한다.
 * 아래의 코드를 살펴보면, String에 있는 Comparable 구현이 두 문자열을 알파벳 순서로 비교하기 때문에 아래의 in 검사에서도 문자열을 알파벳 순서로 비교한다.
 */

fun compStr() {
    println("Kotlin" in "Java".."Scala") // "Java" <= "Kotlin" && "Kotlin" <= "Scala 와 같다.
}

/**
 * 컬렉션에도 in 연산을 이용할 수 있다.
 */
fun compCollection() {
    println("Kotlin" in setOf("Java", "Scala"))
}
