package ch03.함수정의와호출

/**
 * 학습목표
 * 구조 분해 문법을 익힌다.
 */
fun hoo() {

    // to 함수를 사용해 순서쌍을 만든 다음 구조 분해를 통해 그 순서쌍을 풀기
    val (number, name) = 1 to "one"

    // withIndex 함수를 사용과 구조 분해
    val list = listOf(1, 2, 3)
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }
}
