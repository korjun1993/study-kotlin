package ch03.함수정의와호출

import kotlin.text.StringBuilder

/**
 * 학습 목표
 * 확장 프로퍼티 사용법을 익힌다.
 *
 * 확장 프로퍼티
 * 프로퍼티라는 이름으로 불리기는 하지만 상태를 저장할 적절한 방법이 없기 때문에 실제로 확장 프로퍼티는 아무 상태도 가질 수 없다.
 * 하지만 프로퍼티 문법으로 더 짧게 코드를 작성할 수 있어서 편한 경우가 있다.
 * 확장 함수의 경우와 마찬가지로 확장 프로퍼티도 일반적인 프로퍼티와 같은데, 단지 수신 객체 클래스가 추가됐을 뿐이다.
 * 뒷받침하는 필드(프로퍼티의 값을 저장하기 위한 필드)가 없어서 기본 게터 구현을 제공할 수 없으므로 최소한 게터는 꼭 정의해야 한다.
 * 값을 저장할 장소가 전혀 없으므로 초기화 코드도 쓸 수 없다.
 */

val String.lastChar: Char
    get() = get(this.length - 1)

var StringBuilder.lastChar: Char
    get() = get(this.length - 1) // 프로퍼티 게터
    set(value) { // 프로퍼티 세터
        this.setCharAt(length - 1, value)
    }

fun main() {
    println("Kotlin".lastChar)

    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb.lastChar)
}
