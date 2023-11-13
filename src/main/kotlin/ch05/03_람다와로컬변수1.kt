package ch05

/**
 * 자바 메서드 안에서 익명 클래스를 정의했을 때, 메서드의 로컬 변수를 익명 클래스에서 사용할 수 있다.
 * 코틀린의 람다도 비슷하다.
 * 람다를 함수 안에서 정의하면 함수의 파라미터뿐 아니라 람다 정의의 앞에 선언된 로컬 변수까지 람다에서 모두 사용할 수 있다.
 * 람다 안에서 사용하는 외부 변수를 포획(capture)한 변수라고 부른다.
 */

fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach {
        println("$prefix $it")
    }
}

fun main() {
    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessageWithPrefix(errors, "Error: ")
}
