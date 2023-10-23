package ch03.함수정의와호출

/**
 * 학습 목표
 * 인자의 개수가 달라질 수 있는 함수를 정의할 수 있다.
 */

val list = listOf(2, 3, 5, 7, 11)

/**
 * 라이브러리에서 위 함수의 정의를 보면 다음과 같다.
 * fun listOf<T>(vararg values: T): List<T> { ... }
 *
 * 가변 길이 인자는 메서드를 호출할 때 원하는 개수만큼 값을 인자로 넘기면 자바 컴파일러가 배열에 그 값들을 넣어주는 기능이다.
 * 자바에서는 ... 문법을 사용하지만, 코틀린에서는 파라미터 앞에 vararg 변경자를 붙인다.
 * 이미 배열에 들어있는 원소를 가변 길이 인자로 넘길 때, 자바에서는 배열을 그냥 넘기면 되지만 코틀린에서는 배열을 풀어서 전달해야 한다.
 * 스프레드 연산자가 그런 작업을 해준다.
 */

fun main(args: Array<String>) {
    val list = listOf("args:", *args) // 스프레드 연산자가 배열의 내용을 펼쳐준다.
    println(list)
}
